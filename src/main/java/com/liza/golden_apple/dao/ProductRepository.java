package com.liza.golden_apple.dao;

import com.liza.golden_apple.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Products, Integer> {
}
