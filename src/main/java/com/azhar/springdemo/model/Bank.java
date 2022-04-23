package com.azhar.springdemo.model;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Table
@Data
@Entity
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String ifsc;

    @Column
    private String bankAddress;

    @OneToMany(targetEntity = Customer.class)
    private List<Customer> customerList;

}
