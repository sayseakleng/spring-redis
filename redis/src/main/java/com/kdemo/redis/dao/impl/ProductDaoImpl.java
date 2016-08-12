package com.kdemo.redis.dao.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.kdemo.redis.dao.ProductDao;
import com.kdemo.redis.dto.ProductDto;

@Repository
public class ProductDaoImpl implements ProductDao {
	Map<String, ProductDto> productMap = new HashMap<>();

	@Override
	public boolean save(ProductDto product) {
		return productMap.put(product.getProductId(), product) == null;
	}

	@Override
	public Collection<ProductDto> findProducts() {
		return productMap.values();
	}

	@Override
	public boolean modifyProductByProductId(ProductDto product) {
		return productMap.put(product.getProductId(), product) != null;
	}

	@Override
	public boolean deleteProductByProductId(String productId) {
		return productMap.remove(productId) != null;
	}

}
