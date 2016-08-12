package com.kdemo.redis.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import com.kdemo.redis.dao.ProductDao;
import com.kdemo.redis.dto.ProductDto;
import com.kdemo.redis.service.ProductService;

public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao productDao;

	@Override
	public boolean save(ProductDto product) {
		return productDao.save(product);
	}

	@Override
	public Collection<ProductDto> findProducts() {
		return productDao.findProducts();
	}

	@Override
	public boolean modifyProductByProductId(ProductDto product) {
		return productDao.modifyProductByProductId(product);
	}

	@Override
	public boolean deleteProductByProductId(String productId) {
		return productDao.deleteProductByProductId(productId);
		
	}
	
}
