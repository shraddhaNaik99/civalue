package com.example.ciValue2.service;

import java.util.List;

import com.example.ciValue2.entity.Product;

public interface ProductService {
    Product getProductById(Long productId);
    Product createProduct(Product product);
    Product updateProduct(Long productId, Product product);
	void deleteProduct(Long productId);;
}
