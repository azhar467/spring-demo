package com.azhar.springdemo.dto;

import com.azhar.springdemo.model.Bank;
import lombok.Data;

@Data
public class CustomerDto {
    private Integer customerId;
    private String name;
    private String accountNumber;
    private String email;
    private String mobileNumber;
    private Bank bank;
}
