package com.azhar.springdemo.dto;

//import com.azhar.springdemo.model.Customer;
import lombok.Data;

import java.util.List;

@Data
public class BankDto {
    private Integer bankId;
    private String ifsc;
    private String bankAddress;
    //private List<Customer> customerList;
}
