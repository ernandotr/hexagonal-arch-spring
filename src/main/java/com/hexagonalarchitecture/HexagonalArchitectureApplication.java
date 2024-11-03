package com.hexagonalarchitecture;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.hexagonalarchitecture.infrastructure.adapters.repositories.SpringProductRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = SpringProductRepository.class)
public class HexagonalArchitectureApplication {

    public static void main(String[] args) {
        SpringApplication.run(HexagonalArchitectureApplication.class, args);
    }

}
