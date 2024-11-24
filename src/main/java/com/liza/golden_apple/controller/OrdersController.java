package com.liza.golden_apple.controller;

import com.liza.golden_apple.dto.OrdersDTO;
import com.liza.golden_apple.entity.Orders;
import com.liza.golden_apple.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    public OrdersService os;

    @Autowired
    public OrdersController(OrdersService os) {
        this.os = os;
    }

    @GetMapping
    public List<Orders> findAllOrders() {
        return os.findAllOrders();
    }

    @GetMapping("/order_{id}")
    public Orders findOrderById(int id) {
        return os.findOrderById(id);
    }

    @PostMapping("/save")
    public Orders saveOrder(@RequestBody OrdersDTO ordersDTO) {
        return os.saveOrder(ordersDTO);
    }

    @PutMapping("/update")
    public Orders updateOrder(OrdersDTO orders) {
        return os.saveOrder(orders);
    }

    @DeleteMapping("/delete_{id}")
    public void deleteOrderById(@PathVariable int id) {
        os.deleteById(id);
    }
}
