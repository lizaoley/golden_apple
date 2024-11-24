package com.liza.golden_apple.service;

import com.liza.golden_apple.entity.Products;

import java.util.List;

public interface ProductService {

    List<Products> findAll();

    Products findById(int id);

    Products save(Products product);

    void deleteById(int id);

}
