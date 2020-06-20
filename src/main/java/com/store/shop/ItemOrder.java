package com.store.shop;

public class ItemOrder {
    private Item item;
    private int count;

    public ItemOrder(Item item, int count) {
        this.item = item;
        this.count = count;
    }
    public double getTotalWeight(){
        return this.item.getWeight()*this.count;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getTotalPrice() {
        return this.item.getPrice()*this.count;
    }
}
