package com.viniciusaugusto.orderapi.services;


import com.viniciusaugusto.orderapi.dto.ProductDTO;
import com.viniciusaugusto.orderapi.entities.Product;
import com.viniciusaugusto.orderapi.exceptions.ProductNotFoundException;
import com.viniciusaugusto.orderapi.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    public ProductRepository repository;

    public List<ProductDTO> findAll() {
        List<Product> prod = repository.findAll();
        return prod.stream().map(ProductDTO::new).collect(Collectors.toList());
    }

    public ProductDTO findById(Long id) throws ProductNotFoundException {
        return new ProductDTO(repository.findById(id).orElseThrow(() -> new ProductNotFoundException(id)));
    }
    
    public void insert(ProductDTO dto) {
        Product product = repository.save(new Product(dto));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}

