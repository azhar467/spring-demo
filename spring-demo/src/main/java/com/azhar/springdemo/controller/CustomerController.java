package com.azhar.springdemo.controller;

import com.azhar.springdemo.model.Customer;
import com.azhar.springdemo.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping(value = "/customer", produces = "application/json")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @PostMapping("/saveCustomer")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveBank(@RequestBody Customer customer) {
        customerRepository.save(customer);
    }

}
