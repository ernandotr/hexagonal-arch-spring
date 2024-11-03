package com.hexagonalarchitecture.domain.adapters.services;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.hexagonalarchitecture.domain.Product;
import com.hexagonalarchitecture.domain.dtos.ProductDTO;
import com.hexagonalarchitecture.domain.dtos.StockDTO;
import com.hexagonalarchitecture.domain.exceptions.ProductNotFoundException;
import com.hexagonalarchitecture.domain.ports.interfaces.ProductServicePort;
import com.hexagonalarchitecture.domain.ports.repositories.ProductRepositoryPort;

public class ProductServiceImp implements ProductServicePort {

    private final ProductRepositoryPort productRepository;

    public ProductServiceImp(ProductRepositoryPort productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void createProduct(ProductDTO productDTO) {
        Product product = new Product(productDTO);
        this.productRepository.save(product);
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> products = this.productRepository.getAll();
        return products.stream().map(Product::toProductDTO).collect(Collectors.toList());
    }

    @Override
    public void updateStock(String sku, StockDTO stockDTODTO) throws ProductNotFoundException {
        Product product = this.productRepository.findBySku(sku);

        if (Objects.isNull(product))
            throw new ProductNotFoundException("Product not found");

        product.updateStock(stockDTODTO.quantity());

        this.productRepository.save(product);
    }
}
