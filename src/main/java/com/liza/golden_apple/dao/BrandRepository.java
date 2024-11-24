package com.liza.golden_apple.dao;

import com.liza.golden_apple.entity.Brands;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brands, Integer> {
}
