package com.viniciusaugusto.orderapi.services;

import com.viniciusaugusto.orderapi.dto.OrderDTO;
import com.viniciusaugusto.orderapi.entities.Order;
import java.util.List;


public abstract interface OrderService {

    public List<OrderDTO> findAll();

    public OrderDTO findById(Long id);

    public void insert(Order order);

    public void delete(Long id);
}




