package com.store.shop;

public class ItemRequest {
    private int itemID;
    private String name;
    private String brand;
    private int count;

    public ItemRequest(int itemID, String name, String brand, int count) {
        this.itemID = itemID;
        this.name = name;
        this.brand = brand;
        this.count = count;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
