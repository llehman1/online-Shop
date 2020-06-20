package com.store.shop;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;

public class Customer {
    private static int id=0;

    private String email;
    private String pwdhash;
    private int plz;
    private String village;
    private String street;
    private String streetNumber;
    private int customerId;
    private String firstName;
    private String secondName;
    private ArrayList<Order> historyOrder;

    public Customer(int plz, String street, String streetNumber, String firstName, String secondName,String email, String pwdhash, String village) {
        this.plz = plz;
        this.street = street;
        this.streetNumber = streetNumber;
        this.firstName = firstName;
        this.secondName = secondName;
        this.customerId=this.id;
        this.historyOrder=new ArrayList<Order>();
        this.id++;
        this.email = email;
        this.pwdhash = pwdhash;
        this.village=village;

    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public void addOrder(Order order){
        this.historyOrder.add(order);
    }

    @JsonIgnore
    public ArrayList<Order> getHistoryOrder() {
        return historyOrder;
    }

    public int getPlz() {
        return plz;
    }

    public void setPlz(int plz) {
        this.plz = plz;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = this.id;
        this.id=this.id+1;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @JsonIgnore
    public String getPwdhash() {
        return pwdhash;
    }

    public void setPwdhash(String pwdhash) {
        this.pwdhash = pwdhash;
    }
}
