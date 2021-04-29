package com.viniciusaugusto.orderapi.controllers;

import com.viniciusaugusto.orderapi.dto.ProductDTO;
import com.viniciusaugusto.orderapi.entities.Product;
import com.viniciusaugusto.orderapi.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @GetMapping
    public ResponseEntity<List<ProductDTO>> findAll() {
        List<Product> list = repository.findAll();
        List<ProductDTO> dto = list.stream().map(ProductDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id) {
        Optional<Product> prod = repository.findById(id);
        ProductDTO dto = new ProductDTO(prod.get());
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Product> insert(@RequestBody Product product) {
        repository.save(product);
        return ResponseEntity.ok().body(product);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
