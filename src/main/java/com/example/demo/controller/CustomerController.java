package com.example.demo.controller;

import com.example.demo.service.CustomerService;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/custapi")
public class CustomerController {

   // @Autowired
    private CustomerService customerService;

    @RequestMapping("/getCustomers")
    public ResponseEntity<Object> getAllCustomers(){
        return customerService.getAllCustomers();

    }

}
