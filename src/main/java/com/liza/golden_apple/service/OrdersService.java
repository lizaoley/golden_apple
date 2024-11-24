package com.liza.golden_apple.service;

import com.liza.golden_apple.dto.OrdersDTO;
import com.liza.golden_apple.entity.Orders;

import java.util.List;


public interface OrdersService {

    List<Orders> findAllOrders();

    Orders findOrderById(int id);

    Orders saveOrder(OrdersDTO ordersDTO);

    void deleteById(int id);
}
