package com.curso.market.domain;

public class Product {

    private int productId;
    private String name;
    private int categoryId;
    private double price;
    private int stock;
    private boolean active;
    private DomainCategory category;

    public int getProductId() {
        return this.productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return this.stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean isActive() {
        return this.active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public DomainCategory getCategory() {
        return this.category;
    }

    public void setCategory(DomainCategory category) {
        this.category = category;
    }
}
