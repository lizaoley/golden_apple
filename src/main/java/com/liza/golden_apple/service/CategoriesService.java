package com.liza.golden_apple.service;

import com.liza.golden_apple.entity.Categories;

import java.util.List;

public interface CategoriesService {

    List<Categories> findAll();

    Categories findById(int id);

    Categories save(Categories categories);

    void deleteByID(int id);

}
