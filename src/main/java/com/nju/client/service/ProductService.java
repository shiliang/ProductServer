package com.nju.client.service;

import com.nju.client.entity.ProductInfo;

import java.util.List;

public interface ProductService {
    List<ProductInfo> findUpAll();
    List<ProductInfo> findList(List<String> productIdList);
}
