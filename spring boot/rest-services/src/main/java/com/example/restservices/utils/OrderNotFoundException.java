package com.example.restservices.utils;

public class OrderNotFoundException extends RuntimeException{
    public OrderNotFoundException(Long id) {
        super("Could not find order " + id);
    }
}
