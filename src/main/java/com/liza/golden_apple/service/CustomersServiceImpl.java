package com.liza.golden_apple.service;

import com.liza.golden_apple.dao.CustomersRepository;
import com.liza.golden_apple.entity.Customers;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomersServiceImpl implements CustomersService {

    CustomersRepository cr;

    @Autowired
    public CustomersServiceImpl(CustomersRepository cr) {
        this.cr = cr;
    }

    @Override
    public List<Customers> findAllCustomers() {
        return cr.findAll();
    }

    @Override
    public Customers findById(int id) {
        Optional<Customers> c = cr.findById(id);
        Customers newC = null;
        if (c.isPresent()) {
            newC = c.get();
        } else {
            throw new RuntimeException("Customers with ID №" + id + " not found.");
        }
        return newC;
    }

    @Override
    @Transactional
    public Customers saveCustomer(Customers customers) {
        return cr.save(customers);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        cr.deleteById(id);
    }

}
