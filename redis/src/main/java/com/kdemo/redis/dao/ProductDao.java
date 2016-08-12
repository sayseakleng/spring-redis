package com.kdemo.redis.dao;

import java.util.Collection;

import com.kdemo.redis.dto.ProductDto;

public interface ProductDao {
	boolean save(ProductDto product);
	Collection<ProductDto> findProducts();
	boolean modifyProductByProductId(ProductDto product);
	boolean deleteProductByProductId(String productId);
}
