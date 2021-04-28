package com.viniciusaugusto.orderapi.dto;

import com.viniciusaugusto.orderapi.entities.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductDTO {

    private Long id;
    private String name;
    private Double price;

    public ProductDTO(Product product) {
        id = product.getId();
        name = product.getName();
        price = product.getPrice();
    }
}
