package com.hexagonalarchitecture.domain.ports.repositories;

import java.util.List;

import com.hexagonalarchitecture.domain.Product;

public interface ProductRepositoryPort {
    List<Product> getAll();

    Product findBySku(String sku);

    void save(Product product);
}
