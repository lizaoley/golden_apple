package com.liza.golden_apple.service;

import com.liza.golden_apple.entity.Brands;

import java.util.List;

public interface BrandsService {

    List<Brands> findAllBrands();

    Brands findById(int id);

    Brands saveBrand(Brands brands);

    void deleteBrand(int id);
}
