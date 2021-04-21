package com.viniciusaugusto.orderapi.repositories;

import com.viniciusaugusto.orderapi.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
