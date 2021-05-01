package com.viniciusaugusto.orderapi.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ClientNotFoundException extends RuntimeException {

    public ClientNotFoundException(Long id) {
        super(String.format("Not found client with ID: %d", id));
    }
}
