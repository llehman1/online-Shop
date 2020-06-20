package com.store.shop;

public class Item {

    private static int newID = 0;
    private double price;
    private String productName;
    private String description;
    private String pictureUrl;
    private double weight;
    private String brand;
    private int count;
    private int id;

    public Item(double price, String productName, String description, String pictureUrl, double weight, int count, String brand) {
        this.setID();
        this.price = price;
        this.productName = productName;
        this.description = description;
        this.pictureUrl = pictureUrl;
        this.weight = weight;
        this.count = count;
        this.brand = brand;
    }

    public void addCount(int count) {
        this.count = this.count + count;
    }

    public double getPrice() {
        return price;
    }

    private synchronized void setID() {
        this.id = this.newID;
        this.newID++;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
