package com.example.demo.repository;

import com.example.demo.model.Order;
public interface OrderRepository {

    int save(Order record);

    int update(Order order);

    int deleteById(Long id);

    int deleteAll();


}
