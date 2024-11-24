package com.liza.golden_apple.controller;

import com.liza.golden_apple.entity.Products;
import com.liza.golden_apple.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    public ProductService ps;

    @Autowired
    public ProductController(ProductService ps) {
        this.ps = ps;
    }

    @GetMapping
    public List<Products> findAllProducts() {
        return ps.findAll();
    }

    @GetMapping("/product_{id}")
    public Products findProductById(@PathVariable int id) {
        return ps.findById(id);
    }

    @PostMapping("/save")
    public Products saveProduct(@RequestBody Products products) {
        return ps.save(products);
    }

    @PutMapping("/update")
    public Products updateProduct(@RequestBody Products products) {
        return ps.save(products);
    }

    @DeleteMapping("/delete_{id}")
    public void deleteProduct(@PathVariable int id) {
        ps.deleteById(id);
    }
}
