package com.nju.client.service;

import com.nju.client.entity.ProductCategory;
import java.util.List;

public interface CategoryService {
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
