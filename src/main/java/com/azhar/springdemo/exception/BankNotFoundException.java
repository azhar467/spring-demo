package com.azhar.springdemo.exception;

public class BankNotFoundException extends Exception{

    public BankNotFoundException(Integer id){
        super(String.valueOf(id));
    }

}
