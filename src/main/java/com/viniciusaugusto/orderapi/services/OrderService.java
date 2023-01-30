package com.viniciusaugusto.orderapi.services;

import com.viniciusaugusto.orderapi.dto.OrderDTO;
import com.viniciusaugusto.orderapi.entities.Order;
import java.util.List;


public interface OrderService {

    List<OrderDTO> findAll();

    OrderDTO findById(Long id);

    OrderDTO insert(Order order);

    void delete(Long id);
}




