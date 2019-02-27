package com.nju.client.service.impl;

import com.nju.client.entity.ProductInfo;
import com.nju.client.enums.ProductStatusEnum;
import com.nju.client.repository.ProductInfoRepository;
import com.nju.client.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }
}
