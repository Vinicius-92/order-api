package com.viniciusaugusto.orderapi.dto;

import com.viniciusaugusto.orderapi.entities.Product;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
public class ProductDTO {

    private Long id;
    @NotNull(message = "Name can't be null or empty")
    @Size(min = 3, max = 25)
    private String name;
    @NotNull(message = "Price can't be null or empty")
    @Max(value = 999, message = "Price can't exceed 999.00")
    @Min(value = 5, message = "Price can't be lower than 5")
    private Double price;

    public ProductDTO(Product product) {
        id = product.getId();
        name = product.getName();
        price = product.getPrice();
    }
}
