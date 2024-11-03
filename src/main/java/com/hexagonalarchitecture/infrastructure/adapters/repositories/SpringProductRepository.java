package com.hexagonalarchitecture.infrastructure.adapters.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexagonalarchitecture.infrastructure.adapters.entities.ProductEntity;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SpringProductRepository extends JpaRepository<ProductEntity, UUID> {
    Optional<ProductEntity> findBySku(String sku);
}
