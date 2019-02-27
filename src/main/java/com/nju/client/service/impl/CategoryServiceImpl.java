package com.nju.client.service.impl;

import com.nju.client.entity.ProductCategory;
import com.nju.client.repository.ProductCategoryRepository;
import com.nju.client.repository.ProductInfoRepository;
import com.nju.client.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return productCategoryRepository.findByCategoryTypeIn(categoryTypeList);
    }
}
