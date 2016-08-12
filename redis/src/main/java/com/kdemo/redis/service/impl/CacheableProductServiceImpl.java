package com.kdemo.redis.service.impl;

import java.util.Collection;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.kdemo.redis.dto.ProductDto;
import com.kdemo.redis.service.CacheReloadService;
import com.kdemo.redis.service.ProductService;

@Service

public class CacheableProductServiceImpl extends ProductServiceImpl implements ProductService, CacheReloadService {
	public static final String STORE_KEY = "Products";
	
	@Resource(name = "productRedisTemplate")
	private RedisTemplate<String, ProductDto> template;
	
	@Resource(name="productRedisTemplate")
	private HashOperations<String, String, ProductDto> hashOps;

	@Override
	public boolean save(ProductDto product) {
		hashOps.putIfAbsent(STORE_KEY, product.getProductId(), product);
		return super.save(product);
		
	}

	@Override
	public Collection<ProductDto> findProducts() {
		Map<String, ProductDto> entries = hashOps.entries(STORE_KEY);
		return entries.values();
	}



	@Override
	public void reload() {
		template.delete(STORE_KEY);
		Collection<ProductDto> findProducts = super.findProducts();
		for (ProductDto productDto : findProducts) {
			save(productDto);
		}
	}

	@Override
	public boolean modifyProductByProductId(ProductDto product) {
		hashOps.put(STORE_KEY, product.getProductId(), product);
		return super.modifyProductByProductId(product);
	}

	@Override
	public boolean deleteProductByProductId(String productId) {
		hashOps.delete(STORE_KEY, productId);
		return super.deleteProductByProductId(productId);
	}
}
