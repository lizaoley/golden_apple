package com.liza.golden_apple.controller;

import com.liza.golden_apple.entity.Brands;
import com.liza.golden_apple.service.BrandsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brands")
public class BrandsController {

    public BrandsService bs;

    @Autowired
    public BrandsController(BrandsService bs) {
        this.bs = bs;
    }

    @GetMapping
    public List<Brands> findAllB() {
        return bs.findAllBrands();
    }

    @GetMapping("/brand_{id}")
    public Brands findByIdBrands(@PathVariable int id) {
        return bs.findById(id);
    }

    @PostMapping("/save")
    public Brands saveBrands(@RequestBody Brands brands) {
        return bs.saveBrand(brands);
    }

    @PutMapping("/update")
    public Brands updateBrands(@RequestBody Brands brands) {
        return bs.saveBrand(brands);
    }

    @DeleteMapping("/delete_{id}")
    public void deleteBrandsById(@PathVariable int id) {
        bs.deleteBrand(id);
    }
}
