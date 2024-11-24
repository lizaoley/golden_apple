package com.liza.golden_apple.service;

import com.liza.golden_apple.dao.CustomersRepository;
import com.liza.golden_apple.dao.OrdersRepository;
import com.liza.golden_apple.dao.ProductRepository;
import com.liza.golden_apple.dto.OrdersDTO;
import com.liza.golden_apple.entity.Orders;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrdersServiceImpl implements OrdersService {

    private final OrdersRepository or;
    private final CustomersRepository customersRepository;
    private final ProductRepository productRepository;


    @Override
    public List<Orders> findAllOrders() {
        return or.findAll();
    }

    @Override
    public Orders findOrderById(int id) {
        Optional<Orders> order = or.findById(id);
        Orders newOr = null;
        if (order.isPresent()) {
            newOr = order.get();
        } else {
            throw new RuntimeException("Order with ID №" + id + " not found.");
        }
        return newOr;
    }

    @Override
    @Transactional
    public Orders saveOrder(OrdersDTO ordersDTO) {
        var orders = new Orders();
        orders.setOrderDate(new Date());
        orders.setCustomer(customersRepository.findById(ordersDTO.getCustomerId()).orElseThrow());
        orders.setProducts(productRepository.findAllById(ordersDTO.getItems()));

        return or.save(orders);
    }

    public static void main(String[] args) {
        System.out.println(new Date());
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        or.deleteById(id);
    }
}