package com.example.demo.repository;

import com.example.demo.model.Customer;

public interface CustomerRepositroy {

    int save(Customer record);

    int  update(Customer record);

    int deleteById(Long id);

    int deleteAll();

}
