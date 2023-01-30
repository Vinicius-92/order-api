package com.viniciusaugusto.orderapi.controllers;

import com.viniciusaugusto.orderapi.dto.ProductDTO;
import com.viniciusaugusto.orderapi.services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;


@RestController
@Tag(name = "Products")
@RequestMapping(value = "/products",  produces = "application/json")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Returns all products in database.")
    @ApiResponse(responseCode = "200", description = "OK.")
    public ResponseEntity<List<ProductDTO>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping(value = "/{id}")
    @Operation(summary = "Returns product by ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK."),
            @ApiResponse(responseCode = "404", description = "Product not found.")
    })
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id) {
           return ResponseEntity.ok().body(service.findById(id));
    }

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Delete product by ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Deleted with success."),
            @ApiResponse(responseCode = "404", description = "Product not found."),
            @ApiResponse(responseCode = "400", description = "Problem with request.")
    })
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PostMapping
    @Operation(summary = "Create a new product in database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Product created with success."),
            @ApiResponse(responseCode = "400", description = "Problem with request.")
    })
    public ResponseEntity<ProductDTO> insert(@RequestBody @Valid ProductDTO product) {
        var createdProduct = service.insert(product);
        var uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{/id}")
                .buildAndExpand(createdProduct.getId())
                .toUri();
        return ResponseEntity
                .created(uri)
                .body(createdProduct);
    }
}
