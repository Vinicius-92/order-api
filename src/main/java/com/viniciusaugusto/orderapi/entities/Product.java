package com.viniciusaugusto.orderapi.entities;

import com.viniciusaugusto.orderapi.dto.ProductDTO;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double price;

    public Product(ProductDTO dto) {
        this.name = dto.getName();
        this.price = dto.getPrice();
    }
}
