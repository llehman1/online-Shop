package com.store.shop;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

@RestController
public class ShopController {
    private ArrayList<Customer> customerList;
    private ArrayList<Item> itemList;
    private ArrayList<Order> orderList;
    private ArrayList<Order> historyOrderList;

    public ShopController() {
        this.customerList = new ArrayList<Customer>();
        this.itemList = new ArrayList<Item>();
        this.orderList = new ArrayList<Order>();
        this.historyOrderList = new ArrayList<Order>();
        this.createItems();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/versand")
    public ResponseEntity<?> getLogistic(@RequestParam(value = "BestellNR") int id){
        for (Order order: this.orderList){
            if(order.getOrderId()==id){
                return new ResponseEntity<Logistic>(order.getLogistic(),HttpStatus.OK);
            }
        }
        return new ResponseEntity<String>("BestellNr konnte keiner Bestellung zugeordnet werden",HttpStatus.NOT_FOUND);
    }


    @RequestMapping(method = RequestMethod.GET, value = "/allItems")
    public ResponseEntity<ArrayList<Item>> getItems() {
        ArrayList<Item> products = new ArrayList<Item>();
        for (Item item : this.itemList) {
            if (item.getCount() > 0) {
                products.add(item);
            }
        }
        return new ResponseEntity<ArrayList<Item>>(products, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/pay")
    public ResponseEntity getItems(@RequestParam(value = "BestellNR") int id, @RequestParam(value = "pay", defaultValue = "false") boolean pay) {
        for (Order order : this.orderList) {
            if (id == order.getOrderId()) {
                if (pay) {
                    order.pay();
                }
                return new ResponseEntity<ArrayList<Item>>(HttpStatus.OK);
            }
        }
        return new ResponseEntity<ArrayList<Item>>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/dummiRequest")
    public ResponseEntity<OrderRequest> getDummiOrder() {
        ItemRequest item = new ItemRequest(1, "testname", "testbrand", 2);
        OrderRequest orderRequest = new OrderRequest(1, PayState.RECHNUNG);
        orderRequest.addItemList(item);
        return new ResponseEntity<OrderRequest>(orderRequest, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/OrderRequest")
    public ResponseEntity<?> getOrderRequest(@RequestBody OrderRequest orderRequest) {
        Order order = null;
        for (Customer customer : this.customerList) {
            if (customer.getCustomerId() == orderRequest.getCustomerID()) {
                for (ItemRequest itemrequest : orderRequest.getItemList()) {
                    for (Item item : this.itemList) {
                        if (item.getId() == itemrequest.getItemID() && item.getProductName() == itemrequest.getName() && item.getCount() - itemrequest.getCount() >= 0) {
                            order = new Order(customer, orderRequest.getPaymentMethod());
                            order.addItem(new ItemOrder(item, itemrequest.getCount()));
                        }
                    }
                }
            }
        }
        if (order != null) {
            for (Order oldOrder : order.getCustomer().getHistoryOrder()) {
                LocalDate nowDate = LocalDate.now().minusWeeks(4);
                if (oldOrder.getPaymentMethod() == PayState.RECHNUNG && oldOrder.getPay() == false && nowDate.isBefore(oldOrder.getDate())) {
                    return new ResponseEntity<String>("BestellungNR: " + oldOrder.getOrderId() + "muss noch bezahlt werden. Sollange kann keine weiter bestellung getätigt werden", HttpStatus.NOT_ACCEPTABLE);
                }
            }
            if (order.getItemOrders().size() == orderRequest.getItemList().size()) {
                for (ItemOrder itemOrder : order.getItemOrders()) {
                    itemOrder.getItem().addCount((-itemOrder.getCount()));
                }
                orderList.add(order);
                order.getCustomer().addOrder(order);
                return new ResponseEntity<Order>(order, HttpStatus.OK);
            }
        }
        return new ResponseEntity<String>("Fehler im Bestellprozess", HttpStatus.NOT_FOUND);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public ResponseEntity<?> getLogin(@RequestBody Login login) {
        for (Customer customer : this.customerList) {
            if (login.getEmail().equals(customer.getEmail()) && login.getPwdhash().equals(customer.getPwdhash())) {
                return new ResponseEntity<Customer>(customer, HttpStatus.OK);
            }
        }
        return new ResponseEntity<String>("E-Mail oder Passwort falsch", HttpStatus.NOT_FOUND);
    }

    private void createItems() {
        this.itemList.add(new Item(10, "Trainer", "a nice Tennis Ball", "http://www.google.com/abc", 2, 30, "Dunlop"));
        this.itemList.add(new Item(219.90, "Radical", "best Head racket", "http://www.google.com/head", 0.32, 2, "Head"));
        this.itemList.add(new Item(13, "ATP", "ATP Tennis ", "http://www.google.com/test", 0.3, 0, "Dunlop"));
        this.itemList.add(new Item(195.90, "Radical MP", "best racket in the world", "http://www.google.com/head", 0.31, 4, "Head"));
    }

    private void createCustomer() {

    }
}
