# ordermanagement

package com.example.demo.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String email;
    private Integer bill;

    @ManyToMany
    @JoinTable(name="cust_order", joinColumns=@JoinColumn(name="cust_id", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="order_id", referencedColumnName="id"))

    private Collection<Order> orders;

    public Customer(){
    }


    public Customer(Integer id, String name, String email , Collection<Order> orders)
    {
        this.id=id;
        this.name = name;
        this.email = email;
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

    public String getEmail() {
        return email;
    }public void setEmail(String email) {
        this.email = email;
    }

    public Integer getBill() {
        return bill;
    }
    public void setBill(Integer bill) {
        this.bill = bill;
    }

    public Collection<Order> getOrders() {
        return orders;
    }
    public void setOrders(Collection<Order> orders) {
        this.orders = orders;
    }
}

// 
package com.example.demo.model;

public class Menu {
    private Integer m_id;
    private String dish;
    private Integer price;

    public Menu() {
    }

    public Menu(Integer m_id, String dish, Integer price) {
        this.m_id = m_id;
        this.dish=dish;
        this.price=price;

    }

    public Integer getM_id() {
        return m_id;
    }
    public void setM_id(Integer m_id) {
        this.m_id = m_id;
    }

    public String getDish() {
        return dish;
    }
    public void setDish(String dish) {
        this.dish = dish;
    }

    public Integer getPrice() {
        return price;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }
}


//
package com.example.demo.model;

public class Order {

    private Integer id; //ref to customer id i.e foreign key
    private String dish;
    private int qunt;
    private int price;

    public Order(String dish, int qunt){
        this.dish=dish;
        this.qunt=qunt;
    }

    public Order(String dish){
        super();
        this.dish=dish;
    }

    public Order(){
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getDish() {
        return dish;
    }
    public void setItem(String dish) {
        this.dish = dish;
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


//customerrepo

package com.example.demo.repository;

import com.example.demo.model.Customer;

import java.util.List;

public interface CustomerRepo {

    int save(Customer record);

    int  update(Customer record);

  Customer findById(Integer id);

  List<Customer> findAll();


}
  
  //
  package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import com.example.demo.model.Customer;
import com.example.demo.model.Order;

import java.util.List;

public class JdbcCustRepo implements CustomerRepo{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(Customer customer){
        return jdbcTemplate.update("INSERT INTO customer(id, name, email, orders) VALUES(?, ?, ?, ?)",
            new Object[] {customer.getId(), customer.getName(), customer.getEmail(), customer.getOrders() });
    }

    @Override
    public int update(Customer customer){
        return jdbcTemplate.update("UPDATE customers SET name=?, email=? WHERE id=?",
                new Object[] {customer.getName(), customer.getEmail(), customer.getId() });

    }

    @Override
    public Customer findById(Integer id) {
        try {
            Customer customer = jdbcTemplate.queryForObject("SELECT * FROM customer WHERE id=?",
                    BeanPropertyRowMapper.newInstance(Customer.class), id);
            return customer;
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Customer> findAll(){
        return jdbcTemplate.query("SELECT * FROM customer",
                BeanPropertyRowMapper.newInstance(Customer.class));
    }


}

//
  
  package com.example.demo.repository;

import com.example.demo.model.Order;
public interface OrderRepo {

    int save(Order record);

    int update(Order order);

    int deleteById(Long id);

    int deleteAll();


}
  
  //menurepo
  
  package com.example.demo.repository;

import com.example.demo.model.Menu;

import java.util.List;

public interface MenuRepo {

    int save(Menu record);

    int update(Menu record);

    Menu findById(Integer id);

    List<Menu> findAll();


}
  
  //
  
  package com.example.demo.repository;

import com.example.demo.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcMenuRepo implements MenuRepo {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int save(Menu menu) {
        return jdbcTemplate.update("INSERT INTO menu(m_id, dish, price) VALUES(?, ?, ?)",
                new Object[]{menu.getM_id(), menu.getDish(), menu.getPrice()});
    }

    @Override
    public int update(Menu menu) {
        return jdbcTemplate.update("UPDATE menu SET dish=?, price=? WHERE id=?",
                new Object[]{menu.getDish(), menu.getPrice(), menu.getM_id() });
    }

    @Override
    public Menu findById(Integer id){
        try{
            Menu menu= jdbcTemplate.queryForObject("SELECT * FROM meu WHERE id=?",
                   BeanPropertyRowMapper.newInstance(Menu.class), id);
            return menu;
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Menu> findAll() {
        return jdbcTemplate.query("SELECT * FROM menu", BeanPropertyRowMapper.newInstance(Menu.class));
    }

}



//
