package com.yizhiquan.stockadmin.stockadmin.service.impl;

import com.yizhiquan.stockadmin.stockadmin.service.ProductWarehouseStockService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ProductWarehouseStockServiceImpl implements ProductWarehouseStockService {

}
