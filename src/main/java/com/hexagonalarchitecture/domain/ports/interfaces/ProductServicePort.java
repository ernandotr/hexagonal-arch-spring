package com.hexagonalarchitecture.domain.ports.interfaces;

import javassist.NotFoundException;

import java.util.List;

import com.hexagonalarchitecture.domain.dtos.ProductDTO;
import com.hexagonalarchitecture.domain.dtos.StockDTO;

public interface ProductServicePort {

    List<ProductDTO> getAllProducts();

    void createProduct(ProductDTO productDTO);

    void updateStock(String sku, StockDTO stockDTO) throws NotFoundException;
}
