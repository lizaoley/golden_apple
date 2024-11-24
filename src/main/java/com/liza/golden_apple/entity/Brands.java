package com.liza.golden_apple.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "brands")
public class Brands {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brand_id")
    private int brandId;

    @Column(name = "brand_name")
    private String brandName;

    @Column(name = "country")
    private String country;

    @OneToMany(mappedBy = "brands", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Products> products;

    public Brands () {

    }

    public Brands(int brandId, String brandName, String country) {
        this.brandId = brandId;
        this.brandName = brandName;
        this.country = country;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Бренд: " +
                "Id бренда - " + brandId +
                ", имя бренда - " + brandName +
                ", страна происхождения бренда - " + country +
                '.';
    }
}
