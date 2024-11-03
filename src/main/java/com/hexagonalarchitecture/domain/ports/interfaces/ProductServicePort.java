package com.hexagonalarchitecture.domain.ports.interfaces;

import java.util.List;

import com.hexagonalarchitecture.domain.dtos.ProductDTO;
import com.hexagonalarchitecture.domain.dtos.StockDTO;
import com.hexagonalarchitecture.domain.exceptions.ProductNotFoundException;

public interface ProductServicePort {

    List<ProductDTO> getAllProducts();

    void createProduct(ProductDTO productDTO);

    void updateStock(String sku, StockDTO stockDTO) throws ProductNotFoundException;
}
