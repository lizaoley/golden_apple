package com.liza.golden_apple.service;

import com.liza.golden_apple.dao.BrandRepository;
import com.liza.golden_apple.entity.Brands;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandsServiceImpl implements BrandsService {

    BrandRepository br;

    @Autowired
    public BrandsServiceImpl(BrandRepository br) {
        this.br = br;
    }

    @Override
    public List<Brands> findAllBrands() {
        return br.findAll();
    }

    @Override
    public Brands findById(int id) {
        Optional<Brands> b = br.findById(id);
        Brands newb = null;
        if (b.isPresent()) {
            newb = b.get();
        } else {
            throw new RuntimeException("Brand with ID №" + id + " not found.");
        }
        return newb;
    }

    @Override
    @Transactional
    public Brands saveBrand(Brands brands) {
        return br.save(brands);
    }

    @Override
    @Transactional
    public void deleteBrand(int id) {
        br.deleteById(id);
    }
}
