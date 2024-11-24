package com.liza.golden_apple.dao;

import com.liza.golden_apple.entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomersRepository extends JpaRepository<Customers, Integer> {
}
