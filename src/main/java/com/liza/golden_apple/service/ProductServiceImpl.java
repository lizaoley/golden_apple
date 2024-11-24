package com.liza.golden_apple.service;

import com.liza.golden_apple.dao.ProductRepository;
import com.liza.golden_apple.entity.Products;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    ProductRepository pr;

    @Autowired
    public ProductServiceImpl(ProductRepository pr) {
        this.pr = pr;
    }

    @Override
    public List<Products> findAll() {
        return pr.findAll();
    }

    @Override
    public Products findById(int id) {
        Optional<Products> p = pr.findById(id);
        Products newP = null;
        if (p.isPresent()) {
            newP = p.get();
        } else {
            throw new RuntimeException("Product with ID №" + id + " not found.");
        }
        return newP;
    }

    @Override
    @Transactional
    public Products save(Products product) {
        return pr.save(product);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        pr.deleteById(id);
    }
}
