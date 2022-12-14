package com.example.restservices.model;

import com.example.restservices.utils.Status;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "CUSTOMER_ORDER")
public class Order {
    @Id
    @GeneratedValue
    private Long id;
    private String description;
    private Status status;

    public Order() {}
    public Order(String description, Status status)  {
        this.description = description;
        this.status = status;
    }
}
