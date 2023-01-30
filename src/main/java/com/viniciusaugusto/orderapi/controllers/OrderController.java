package com.viniciusaugusto.orderapi.controllers;

import com.viniciusaugusto.orderapi.dto.OrderDTO;
import com.viniciusaugusto.orderapi.entities.Order;
import com.viniciusaugusto.orderapi.services.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.lang.annotation.Target;
import java.util.List;

@RestController
@Tag(name = "Orders")
@RequestMapping(value = "/orders", produces = "application/json")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Returns all orders in database.")
    @ApiResponse(responseCode = "200", description = "OK.")
    public ResponseEntity<List<OrderDTO>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping(value = "/{id}")
    @Operation(summary = "Returns order by ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK."),
            @ApiResponse(responseCode = "404", description = "Order not found.")
    })
    public ResponseEntity<OrderDTO> findById(@PathVariable Long id) {
          return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping
    @Operation(summary = "Create a new order in database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Order created with success."),
            @ApiResponse(responseCode = "400", description = "Problem with request.")
    })
    public void insert (@RequestBody @Valid Order order) {
        service.insert(order);
    }

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Delete order by ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Deleted with success."),
            @ApiResponse(responseCode = "404", description = "Order not found."),
            @ApiResponse(responseCode = "400", description = "Problem with request.")
    })
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}