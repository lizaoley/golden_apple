package com.liza.golden_apple.dao;

import com.liza.golden_apple.entity.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesRepository extends JpaRepository<Categories, Integer> {

}
