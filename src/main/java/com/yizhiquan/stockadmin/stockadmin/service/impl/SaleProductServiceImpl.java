package com.yizhiquan.stockadmin.stockadmin.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yizhiquan.stockadmin.stockadmin.dao.ProductSpecMapper;
import com.yizhiquan.stockadmin.stockadmin.dao.SaleProductMapper;
import com.yizhiquan.stockadmin.stockadmin.domain.ProductSpec;
import com.yizhiquan.stockadmin.stockadmin.domain.SaleProduct;
import com.yizhiquan.stockadmin.stockadmin.domain.vo.SaleProductVo;
import com.yizhiquan.stockadmin.stockadmin.service.SaleProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class SaleProductServiceImpl implements SaleProductService {
    private SaleProductMapper saleProductMapper;

    private ProductSpecMapper productSpecMapper;

    @Autowired
    SaleProductServiceImpl(SaleProductMapper saleProductMapper,ProductSpecMapper productSpecMapper){
        this.saleProductMapper=saleProductMapper;
        this.productSpecMapper=productSpecMapper;
    }

//    DateTimeFormatter formatter = DateTimeFormatter.BASIC_ISO_DATE;
//    LocalDate formatted = LocalDate.parse(specifyDate,formatter);

    @Override
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public void saveSaleProduct(SaleProductVo saleProduct) throws Exception {
        // Step1 删减库存
        ProductSpec productSpecParam = ProductSpec.builder().color(saleProduct.getColor())
                .productId(saleProduct.getProductId())
                .size(saleProduct.getSize())
                .build();
        List<ProductSpec> productSpecs = productSpecMapper.selectProductBySpec(productSpecParam);
        if(!CollectionUtils.isEmpty(productSpecs)){
            ProductSpec productSpec = productSpecs.get(0);
            int quantity=productSpecs.get(0).getQuantity()-saleProduct.getQuantity();
            productSpec.setQuantity(quantity);
            productSpecMapper.updateProductStock(productSpec);
        }

        // Step2 保存销售信息
        SaleProduct sale = builderSaleProduct(saleProduct);
        saleProductMapper.insertSelective(sale);
    }

    @Override
    public Page<SaleProduct> findListPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        Page<SaleProduct> saleProductPageData=saleProductMapper.selectSaleProduct();
        return saleProductPageData;
    }

    @Override
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public void deleteSaleProduct(Integer id) {
        saleProductMapper.deleteSaleProduct(id);
    }

    @Override
    public SaleProduct selectSaleById(Integer id) {
        return saleProductMapper.selectSaleProductById(id);
    }

    private SaleProduct builderSaleProduct(SaleProductVo saleProductVo) throws ParseException {
        Date saleTime =null;
        if(!StringUtils.isEmpty(saleProductVo.getSaleTime())){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            saleTime= simpleDateFormat.parse(saleProductVo.getSaleTime());
        }
        SaleProduct saleProduct = SaleProduct.builder()
                .productCode(saleProductVo.getProductCode())
                .productName(saleProductVo.getProductName())
                .color(saleProductVo.getColor())
                .size(saleProductVo.getSize())
                .salesperson(saleProductVo.getSalesperson())
                .quantity(saleProductVo.getQuantity())
                .totalMoney(saleProductVo.getTotalMoney())
                .storeId(saleProductVo.getStoreId())
                .saleTime(saleTime)
                .build();
        return saleProduct;
    }
}
