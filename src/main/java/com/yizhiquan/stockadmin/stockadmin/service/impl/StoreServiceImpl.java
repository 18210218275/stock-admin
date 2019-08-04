package com.yizhiquan.stockadmin.stockadmin.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yizhiquan.stockadmin.stockadmin.dao.StoreMapper;
import com.yizhiquan.stockadmin.stockadmin.domain.Store;
import com.yizhiquan.stockadmin.stockadmin.domain.vo.PageData;
import com.yizhiquan.stockadmin.stockadmin.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class StoreServiceImpl implements StoreService {
    private StoreMapper storeMapper;

    @Autowired
    public StoreServiceImpl(StoreMapper storeMapper){
        this.storeMapper=storeMapper;
    }

    @Override
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public void saveStore(Store store) {
        if(store.getId()!=null){
            storeMapper.updateStore(store);
        }else{
            storeMapper.insertSelective(store);
        }

    }

    @Override
    public PageData<Store> findStoreList(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        Page<Store> pageStoreList=storeMapper.selectStore();
        PageData<Store> storePageData = PageData.<Store>builder()
                .pageNum(pageNum)
                .pageSize(pageSize)
                .totalNum(pageStoreList.getTotal())
                .totalPage(pageStoreList.getPages())
                .data(pageStoreList.getResult())
                .build();
        return storePageData;
    }

    @Override
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public void deleteStore(Integer id) {
        storeMapper.deleteStore(id);
    }

    @Override
    public Store getStoreById(Integer id) {
        return storeMapper.getStoreById(id);
    }
}
