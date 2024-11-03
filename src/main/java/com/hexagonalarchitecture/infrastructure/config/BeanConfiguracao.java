package com.hexagonalarchitecture.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hexagonalarchitecture.domain.adapters.services.ProductServiceImp;
import com.hexagonalarchitecture.domain.ports.interfaces.ProductServicePort;
import com.hexagonalarchitecture.domain.ports.repositories.ProductRepositoryPort;

@Configuration
public class BeanConfiguracao {

    @Bean
    ProductServicePort productService(ProductRepositoryPort productRepositoryPort) {
        return new ProductServiceImp(productRepositoryPort);
    }
}
