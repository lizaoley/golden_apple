package com.liza.golden_apple.service;

import com.liza.golden_apple.entity.Customers;

import java.util.List;

public interface CustomersService {

    List<Customers> findAllCustomers();

    Customers findById(int id);

    Customers saveCustomer(Customers customers);

    void deleteById(int id);
}
