package com.liza.golden_apple.controller;

import com.liza.golden_apple.entity.Categories;
import com.liza.golden_apple.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoriesController {

    public CategoriesService cs;

    @Autowired
    public CategoriesController(CategoriesService cs) {
        this.cs = cs;
    }

    @GetMapping
    public List<Categories> findAllC() {
        return cs.findAll();
    }

    @GetMapping("/{id}")
    public Categories findByIdC(@PathVariable int id) {
        return cs.findById(id);
    }

    @DeleteMapping("/delete_{id}")
    public void deleteByIdC(@PathVariable int id) {
        cs.deleteByID(id);
    }

    @PostMapping("/save")
    public Categories saveC(@RequestBody Categories categories) {
        return cs.save(categories);
    }

    @PutMapping("/update")
    public Categories updateC(@RequestBody Categories categories) {
        return cs.save(categories);
    }

}
