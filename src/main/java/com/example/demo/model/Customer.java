package com.example.demo.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String number;


    @ManyToMany
    @JoinTable(name="cust_order", joinColumns=@JoinColumn(name="cust_id", referencedColumnName="id"),inverseJoinColumns=@JoinColumn(name="order_id", referencedColumnName="id"))

    private Collection<Order> orders;

    public Customer(){
    }

    public Customer(String name, String number, Collection<Order> orders)
    {
        this.name = name;
        this.number = number;
        this.orders=orders;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }

    public Collection<Order> getOrders() {
        return orders;
    }
    public void setOrders(Collection<Order> orders) {
        this.orders = orders;
    }
}

