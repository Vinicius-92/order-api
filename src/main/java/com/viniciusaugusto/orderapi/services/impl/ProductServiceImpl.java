package com.viniciusaugusto.orderapi.services.impl;

import com.viniciusaugusto.orderapi.dto.ProductDTO;
import com.viniciusaugusto.orderapi.entities.Product;
import com.viniciusaugusto.orderapi.exceptions.ProductNotFoundException;
import com.viniciusaugusto.orderapi.repositories.ProductRepository;
import com.viniciusaugusto.orderapi.services.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    public ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ProductDTO> findAll() {
        List<Product> prod = repository.findAll();
        return prod.stream().map(ProductDTO::new).collect(Collectors.toList());
    }

    @Override
    public ProductDTO findById(Long id) throws ProductNotFoundException {
        return new ProductDTO(repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id)));
    }

    @Override
    public ProductDTO insert(ProductDTO dto) {
        var productSaved = repository.save(new Product(dto));
        return new ProductDTO(productSaved);
    }

    @Override
    public void delete(Long id) {
        this.findById(id);
        repository.deleteById(id);
    }
}
