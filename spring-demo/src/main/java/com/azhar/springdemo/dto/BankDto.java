package com.azhar.springdemo.dto;

import lombok.Data;

@Data
public class BankDto {
    private Integer bankId;
    private String ifsc;
    private String bankAddress;
}
