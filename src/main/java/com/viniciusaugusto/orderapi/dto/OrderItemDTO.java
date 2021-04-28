package com.viniciusaugusto.orderapi.dto;

import com.viniciusaugusto.orderapi.entities.Order;
import com.viniciusaugusto.orderapi.entities.OrderItem;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderItemDTO {

    private Long id;
    private Integer quantity;
    private Double price;
    private ProductDTO product;
    private Order order;
    public double getSubTotal;

    public OrderItemDTO(OrderItem orderItem) {
        id = orderItem.getId();
        quantity = orderItem.getQuantity();
        price = orderItem.getPrice();
        product = new ProductDTO(orderItem.getProduct());
        order = orderItem.getOrder(); //Need to create OrderDTO
        getSubTotal = orderItem.getSubTotal(); //Search how to implement subTotal method into DTO's
    }
}