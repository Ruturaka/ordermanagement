package com.example.demo.service;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

  //  @Autowired
    private CustomerRepository customerRepository;
    public ResponseEntity<Object> getAllCustomers() {
        List<Customer> dbCustomers = customerRepository.findAll();
        if (dbCustomers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(dbCustomers, HttpStatus.OK);
    }
}
