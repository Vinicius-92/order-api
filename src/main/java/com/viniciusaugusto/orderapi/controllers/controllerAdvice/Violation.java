package com.viniciusaugusto.orderapi.controllers.controllerAdvice;

import lombok.Data;

@Data
public class Violation {
    private final String fieldName;
    private final String message;
}
