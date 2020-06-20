package com.store.shop;

import java.util.ArrayList;

public class OrderRequest {
    private int customerID;
    private ArrayList<ItemRequest> itemList;
    private PayState paymentMethod;

    public OrderRequest(int customerID , PayState paymentMethod) {
        this.customerID = customerID;
        this.itemList = new ArrayList<ItemRequest>();
        this.paymentMethod= paymentMethod;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public ArrayList<ItemRequest> getItemList() {
        return itemList;
    }

    public void setItemList(ArrayList<ItemRequest> itemList) {
        this.itemList = itemList;
    }

    public PayState getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PayState paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    public void addItemList(ItemRequest itemRequest){
        this.itemList.add(itemRequest);
    }
}
