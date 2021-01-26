//package com.azhar.springdemo.model;
//
//import lombok.Data;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.relational.core.mapping.Column;
//import org.springframework.data.relational.core.mapping.Table;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.ManyToOne;
//
//@Data
//@Entity
//@Table
//public class Customer {
//
//    @Id
//    @GeneratedValue(strategy= GenerationType.AUTO)
//    private Integer customerId;
//    @Column
//    private String name;
//    @Column
//    private String accountNumber;
//    @Column
//    private String email;
//    @Column
//    private String mobileNumber;
//    @ManyToOne
//    private Bank bank;
//}
