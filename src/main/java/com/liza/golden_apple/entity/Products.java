package com.liza.golden_apple.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int productId;

    @Column(name = "product_name")
    private String productName;

    @ManyToOne
    @JoinColumn(name = "brand_id", nullable = false)
    @JsonIgnore
    private Brands brands;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    @JsonIgnore
    private Categories category;

    @Column(name = "price")
    private double price;

    @Column(name = "stock_quantity")
    private int stockQuantity;

    @ManyToMany(mappedBy = "products")
    private List<Orders> orders;

    @Transient
    private int brandId;

    @Transient
    private int categoryId;

    public Products() {
    }

    public Products(int productId, String productName, Brands brands, Categories category, double price, int stockQuantity) {
        this.productId = productId;
        this.productName = productName;
        this.brands = brands;
        this.category = category;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.brandId = brands != null ? brands.getBrandId() : 0;
        this.categoryId = category != null ? category.getCategoryId() : 0;
    }

    @PostLoad
    private void initIds() {
        this.brandId = brands != null ? brands.getBrandId() : 0;
        this.categoryId = category != null ? category.getCategoryId() : 0;
    }

    // Геттеры и сеттеры

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Brands getBrands() {
        return brands;
    }

    public void setBrands(Brands brands) {
        this.brands = brands;
        this.brandId = brands != null ? brands.getBrandId() : 0;
    }

    public Categories getCategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
        this.categoryId = category != null ? category.getCategoryId() : 0;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    public int getBrandId() {
        return brandId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    @Override
    public String toString() {
        return "Продукт: " +
                "Id продукта - " + productId +
                ", название продукта - " + productName +
                ", бренд - " + (brands != null ? brands.getBrandName() : "не указан") +
                ", категория - " + (category != null ? category.getCategoryName() : "не указана") +
                ", цена продукта - " + price +
                ", количество на складе - " + stockQuantity +
                '.';
    }
}
