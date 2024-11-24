package com.liza.golden_apple.controller;

import com.liza.golden_apple.entity.Customers;
import com.liza.golden_apple.service.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomersController {

    public CustomersService cs;

    @Autowired
    public CustomersController(CustomersService cs) {
        this.cs = cs;
    }

    @GetMapping
    public List<Customers> findAllCustomers() {
        return cs.findAllCustomers();
    }

    @GetMapping("/customer_{id}")
    public Customers findCustomerById(@PathVariable int id) {
        return cs.findById(id);
    }

    @PostMapping("/save")
    public Customers saveCustomer(@RequestBody Customers customers) {
        return cs.saveCustomer(customers);
    }

    @PutMapping("/update")
    public Customers updateCustomer(@RequestBody Customers customers) {
        return cs.saveCustomer(customers);
    }

    @DeleteMapping("/delete_{id}")
    public void deleteCustomer(@PathVariable int id) {
        cs.deleteById(id);
    }

}
