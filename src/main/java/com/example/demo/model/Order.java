package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int order_id;
    private Integer id; //ref to customer id i.e foreign key
    private String item;
    private int qunt;
    private int price;

    public Order(String item, int qunt){
        this.item=item;
        this.qunt=qunt;
    }

    public Order(String item){
        super();
        this.item=item;
    }

    public Order(){
    }

    public int getOrder_id() {
        return order_id;
    }
    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }
    public void setItem(String item) {
        this.item = item;
    }

    public int getQunt() {
        return qunt;
    }
    public void setQunt(int qunt) {
        this.qunt = qunt;
    }

    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

}
