package com.hexagonalarchitecture.infrastructure.adapters.entities;

import javax.persistence.*;

import com.hexagonalarchitecture.domain.Product;

import java.util.UUID;

@Entity
@Table(name = "products")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID codigo;
    private String sku;
    private String nome;
    private Double preco;
    private Double quantidade;

    public ProductEntity() {
    }

    public ProductEntity(Product product) {
        this.sku = product.getSku();
        this.nome = product.getName();
        this.preco = product.getPrice();
        this.quantidade = product.getQuantity();
    }

    public void atualizar(Product product) {
        this.sku = product.getSku();
        this.nome = product.getName();
        this.preco = product.getPrice();
        this.quantidade = product.getQuantity();
    }

    public Product toProduct() {
        return new Product(this.codigo, this.sku, this.nome, this.quantidade, this.preco);
    }
}
