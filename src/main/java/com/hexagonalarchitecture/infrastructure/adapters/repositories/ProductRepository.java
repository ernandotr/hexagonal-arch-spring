package com.hexagonalarchitecture.infrastructure.adapters.repositories;

import org.springframework.stereotype.Component;

import com.hexagonalarchitecture.domain.Product;
import com.hexagonalarchitecture.domain.exceptions.ProductNotFoundException;
import com.hexagonalarchitecture.domain.ports.repositories.ProductRepositoryPort;
import com.hexagonalarchitecture.infrastructure.adapters.entities.ProductEntity;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ProductRepository implements ProductRepositoryPort {

    private final SpringProductRepository springProductRepository;

    public ProductRepository(SpringProductRepository springProductRepository) {
        this.springProductRepository = springProductRepository;
    }

    @Override
    public List<Product> getAll() {
        List<ProductEntity> productEntities = this.springProductRepository.findAll();
        return productEntities.stream().map(ProductEntity::toProduct).collect(Collectors.toList());
    }

    @Override
    public Product findBySku(String sku) {
        Optional<ProductEntity> productEntity = this.springProductRepository.findBySku(sku);

        if (productEntity.isPresent())
            return productEntity.get().toProduct();

        throw new ProductNotFoundException("Product doesn't exist.");
    }

    @Override
    public void save(Product product) {
        ProductEntity productEntity;
        if (Objects.isNull(product.getId()))
            productEntity = new ProductEntity(product);
        else {
            productEntity = this.springProductRepository.findById(product.getId()).get();
            productEntity.atualizar(product);
        }

        this.springProductRepository.save(productEntity);
    }
}
