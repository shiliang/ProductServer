package com.nju.client.service;

import com.nju.client.DTO.CartDTO;
import com.nju.client.entity.ProductInfo;

import java.util.List;

public interface ProductService {
    List<ProductInfo> findUpAll();
    List<ProductInfo> findList(List<String> productIdList);

    //扣库存
    void decreaseStock(List<CartDTO> cartDTOList);
}
