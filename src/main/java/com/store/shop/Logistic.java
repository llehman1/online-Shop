package com.store.shop;

public class Logistic {
    private Order order;

    public Logistic(Order order) {
        this.order = order;
    }

    public String getPlace(){
        return this.order.getCustomer().getPlz()+" "+this.order.getCustomer().getVillage();
    }
    public String getAdress(){
        return this.order.getCustomer().getStreet()+" "+this.order.getCustomer().getStreetNumber();
    }
    public String getName(){
        return this.order.getCustomer().getFirstName()+" "+this.order.getCustomer().getSecondName();
    }
    public String getWeight(){
        return order.getTotalWeight()+" kg";
    }
}
