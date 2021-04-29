package com.viniciusaugusto.orderapi.dto;

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
    private String product;
    private Long order;
    public double getSubTotal;

    public OrderItemDTO(OrderItem orderItem) {
        id = orderItem.getId();
        quantity = orderItem.getQuantity();
        price = orderItem.getPrice();
        product = orderItem.getProduct().getName();
        order = orderItem.getOrder().getId();
        getSubTotal = orderItem.getSubTotal();
    }
}
