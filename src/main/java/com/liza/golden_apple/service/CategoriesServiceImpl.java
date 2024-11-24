package com.liza.golden_apple.service;

import com.liza.golden_apple.dao.CategoriesRepository;
import com.liza.golden_apple.entity.Categories;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriesServiceImpl implements CategoriesService {

    public CategoriesRepository cr;

    @Autowired
    public CategoriesServiceImpl(CategoriesRepository cr) {
        this.cr = cr;
    }

    @Override
    public List<Categories> findAll() {
        return cr.findAll();
    }

    @Override
    public Categories findById(int id) {
        Optional<Categories> c = cr.findById(id);
        Categories newC = null;
        if (c.isPresent()) {
            newC = c.get();
        } else {
            throw new RuntimeException("Categories with ID №" + id + " not found.");
        }
        return newC;
    }

    @Override
    @Transactional
    public Categories save(Categories categories) {
        return cr.save(categories);
    }

    @Override
    @Transactional
    public void deleteByID(int id) {
        cr.deleteById(id);
    }
}
