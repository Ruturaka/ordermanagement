package com.example.demo.model;

public class OrderedItem {
    private int Order_id; // from order table -  foreign key
    private String item;
    private int price; // from menu table;
    private int qunt; // from order table;
    private int item_id; //every item order will have its own item_id
    private int menu_id; // from menu table -  foreign key

    private int amnt;

}
