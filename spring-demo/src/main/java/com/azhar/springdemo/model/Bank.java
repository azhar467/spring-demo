package com.azhar.springdemo.model;

import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;

@Table
@Data
@Entity
@Audited
public class Bank implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column
    private Integer bankId;

    @Column
    private String ifsc;

    @Column
    private String bankAddress;

//    @OneToMany
//    private List<Customer> customerList;

}
