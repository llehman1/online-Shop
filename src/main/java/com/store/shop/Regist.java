package com.store.shop;

public class Regist {
    private String pwdhash;
    private Customer customer;

    public Regist(String pwdhash, Customer customer) {
        this.pwdhash = pwdhash;
        this.customer = customer;
    }

    public String getPwdhash() {
        return pwdhash;
    }

    public void setPwdhash(String pwdhash) {
        this.pwdhash = pwdhash;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
