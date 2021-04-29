package com.viniciusaugusto.orderapi.controllers;

import com.viniciusaugusto.orderapi.dto.OrderDTO;
import com.viniciusaugusto.orderapi.entities.Order;
import com.viniciusaugusto.orderapi.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping
    public ResponseEntity<List<OrderDTO>> findAll() {
        List<Order> list = orderRepository.findAll();
        List<OrderDTO> dto = list.stream().map(OrderDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<OrderDTO> findById(@PathVariable Long id) {
        Optional<Order> order = orderRepository.findById(id);
        OrderDTO dto = new OrderDTO(order.get());
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Order> insert (@RequestBody Order order) {
        orderRepository.save(order);
        return ResponseEntity.ok().body(order);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        orderRepository.deleteById(id);
    }
}