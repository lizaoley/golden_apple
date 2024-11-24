package com.liza.golden_apple.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer orderId;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    @JsonIgnore
    private Customers customer;

    @Transient
    private int customerId;

    @Column(name = "order_date")
    private Date orderDate;

    @Column(name = "total_price")
    private double totalPrice;

    @ManyToMany
    @JoinTable(name="order_product")
    private List<Products> products;

    public Orders() {
    }

    public Orders(int orderId, Customers customer, Date orderDate, double totalPrice) {
        this.orderId = orderId;
        this.customer = customer;
        this.customerId = customer != null ? customer.getCustomerId() : 0;
        this.orderDate = orderDate;
        this.totalPrice = totalPrice;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Customers getCustomer() {
        return customer;
    }

    public void setCustomer(Customers customer) {
        this.customer = customer;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> orderProducts) {
        this.products = orderProducts;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Заказ: " +
                "Id заказа - " + orderId +
                ", Id покупателя - " + (customer != null ? customer.getCustomerId() : "не указан") +
                ", дата заказа - " + orderDate +
                ", полная стоимость заказа - " + totalPrice +
                '.';
    }
}
