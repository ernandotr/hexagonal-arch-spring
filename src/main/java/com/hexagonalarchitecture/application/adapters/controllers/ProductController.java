package com.hexagonalarchitecture.application.adapters.controllers;

import org.springframework.web.bind.annotation.*;

import com.hexagonalarchitecture.domain.dtos.ProductDTO;
import com.hexagonalarchitecture.domain.dtos.StockDTO;
import com.hexagonalarchitecture.domain.exceptions.ProductNotFoundException;
import com.hexagonalarchitecture.domain.ports.interfaces.ProductServicePort;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {

    private final ProductServicePort productServicePort;

    public ProductController(ProductServicePort productServicePort) {
        this.productServicePort = productServicePort;
    }

    @PostMapping
    void createProducts(@RequestBody ProductDTO productDTO) {
        productServicePort.createProduct(productDTO);
    }

    @GetMapping
    List<ProductDTO> getProducts() {
        return productServicePort.getAllProducts();
    }

    @PutMapping(value = "/{sku}")
    void updateStock(@PathVariable String sku, @RequestBody StockDTO stockDTO) throws ProductNotFoundException {
        productServicePort.updateStock(sku, stockDTO);
    }
}
