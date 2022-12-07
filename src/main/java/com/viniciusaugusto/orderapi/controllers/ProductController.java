package com.viniciusaugusto.orderapi.controllers;

import com.viniciusaugusto.orderapi.dto.ProductDTO;
import com.viniciusaugusto.orderapi.repositories.ProductRepository;
import com.viniciusaugusto.orderapi.services.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Api(tags = "Products")
@RequestMapping(value = "/products",  produces = "application/json")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    @ApiOperation(value = "Returns all products in database.")
    @ApiResponse(code = 200, message = "OK.")
    public ResponseEntity<List<ProductDTO>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Returns product by ID.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK."),
            @ApiResponse(code = 404, message = "Product not found.")
    })
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id) {
           return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping
    @ApiOperation(value = "Create a new product in database.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Product created with success."),
            @ApiResponse(code = 400, message = "Problem with request.")
    })
    public void insert(@RequestBody ProductDTO product) {
        service.insert(product);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "Delete product by ID.")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Deleted with success."),
            @ApiResponse(code = 404, message = "Product not found."),
            @ApiResponse(code = 400, message = "Problem with request.")
    })
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
