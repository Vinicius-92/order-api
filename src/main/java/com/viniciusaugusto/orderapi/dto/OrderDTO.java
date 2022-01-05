package com.viniciusaugusto.orderapi.dto;

import com.viniciusaugusto.orderapi.dto.responses.ClientResponseDTO;
import com.viniciusaugusto.orderapi.entities.Order;
import com.viniciusaugusto.orderapi.enums.OrderStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class OrderDTO {

    private Long id;
    private Instant moment;
    private OrderStatus status;
    private ClientResponseDTO client;
    private List<OrderItemDTO> items = new ArrayList<>();
    private Double getTotal;

    public OrderDTO(Order order) {
        id = order.getId();
        moment = order.getMoment();
        status = order.getStatus();
        client = new ClientResponseDTO(order.getClient());
        order.getItems().forEach(item -> this.items.add(new OrderItemDTO(item)));
        getTotal = order.getTotal();
    }
}

