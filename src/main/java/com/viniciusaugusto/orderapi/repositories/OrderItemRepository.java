package com.viniciusaugusto.orderapi.repositories;

import com.viniciusaugusto.orderapi.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
