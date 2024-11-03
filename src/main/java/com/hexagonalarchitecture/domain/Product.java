package com.hexagonalarchitecture.domain;

import java.util.UUID;

import com.hexagonalarchitecture.domain.dtos.ProductDTO;

public class Product {

    private UUID id;
    private String sku;
    private String name;
    private Double price;
    private Double quantity;

    public Product() {
    }

    public Product(UUID id, String sku, String name, Double quantity, Double price) {
        this.id = id;
        this.sku = sku;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public UUID getId() {
        return id;
    }

    public String getSku() {
        return sku;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Double getQuantity() {
        return quantity;
    }

    public Product(ProductDTO productDTO) {
        this.sku = productDTO.sku();
        this.name = productDTO.name();
        this.price = productDTO.price();
        this.quantity = productDTO.quantity();
    }

    public void updateStock(double quantity) {
        this.quantity = quantity;
    }

    public ProductDTO toProductDTO() {
        return new ProductDTO(this.sku, this.name, this.price, this.quantity);
    }
}
