package com.viniciusaugusto.orderapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class OrderNotFoundException extends RuntimeException{

    public OrderNotFoundException(Long id) {
        super("Order not found with ID: " + id);
    }
}
