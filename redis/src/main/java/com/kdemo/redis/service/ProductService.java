package com.kdemo.redis.service;

import java.util.Collection;

import com.kdemo.redis.dto.ProductDto;

public interface ProductService {
	boolean save(ProductDto product);
	Collection<ProductDto> findProducts();
	boolean modifyProductByProductId(ProductDto product);
	boolean deleteProductByProductId(String productId);
}
