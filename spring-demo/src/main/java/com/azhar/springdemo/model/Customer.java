package com.azhar.springdemo.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Data
@Entity
@Table
public class Customer extends EntityWithUUID {

    @Column
    private String customerName;

    @Column
    private String accountNumber;

    @Column
    @Email
    private String email;

    @Column
    private String mobileNumber;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_customer_bank"))
    private Bank bank;

}
