package com.viniciusaugusto.orderapi.services;


import com.viniciusaugusto.orderapi.dto.ProductDTO;
import java.util.List;

public abstract interface ProductService {
     public List<ProductDTO> findAll();

    public ProductDTO findById(Long id);
    
    public void insert(ProductDTO dto);

    public void delete(Long id);
}

