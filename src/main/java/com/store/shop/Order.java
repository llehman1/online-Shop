package com.store.shop;



import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order {
    private static int id = 0;
    private int orderId;
    private ArrayList<ItemOrder> itemOrders;
    private LocalDate time;
    private boolean pay;
    private Customer customer;
    private PayState paymentMethod;

    public Order(Customer customer, PayState paymentMethod) {
        this.itemOrders = new ArrayList<ItemOrder>();
        this.time = LocalDate.now();
        this.customer = customer;
        this.pay = false;
        this.orderId = id;
        this.paymentMethod = paymentMethod;
        id++;
    }

    public void addItem(ItemOrder item) {
        this.itemOrders.add(item);
    }

    public double getTotalWeight() {
        double totalWeight = 0;
        for (ItemOrder item : this.itemOrders) {
            totalWeight = totalWeight + item.getTotalWeight();
        }
        return totalWeight;
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (ItemOrder item : this.itemOrders) {
            totalPrice = totalPrice + item.getTotalPrice();
        }
        return totalPrice;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ArrayList<ItemOrder> getItemOrders() {
        return itemOrders;
    }

    public LocalDate getDate() {
        return time;
    }

    public int getOrderId() {
        return orderId;
    }

    public boolean getPay() {
        return pay;
    }

    public void pay() {
        this.pay = true;
    }

    public PayState getPaymentMethod() {
        return paymentMethod;
    }

    @JsonIgnore
    public Logistic getLogistic() {
        return new Logistic(this);
    }


}
