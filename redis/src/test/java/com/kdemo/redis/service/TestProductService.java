package com.kdemo.redis.service;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kdemo.redis.dto.ProductDto;
import com.kdemo.redis.service.CacheReloadService;
import com.kdemo.redis.service.ProductService;
import com.kdemo.redis.spring.SpringConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class TestProductService {
	@Autowired
	private ProductService productService;

	@Test
	public void testSave() {
		ProductDto product = new ProductDto("1", "A1");
		boolean save = productService.save(product);
		assertTrue(save);
	}
	
	@Ignore @Test
	public void testReload() {
		if(productService instanceof CacheReloadService) {
			CacheReloadService reloadService = (CacheReloadService) productService;
			reloadService.reload();
		}
	}
	
	@Test
	public void testModifyProductByProductId() {
		ProductDto product = new ProductDto("1", "A1");
		productService.save(product);
		
		product = new ProductDto("1", "B1");
		boolean modifyProductByProductId = productService.modifyProductByProductId(product);
		assertTrue(modifyProductByProductId);
		
	}
	
	@Test
	public void testFindProducts() {
		Collection<ProductDto> findProducts = productService.findProducts();
		assertNotSame(findProducts.size(), 0);
		System.out.println(findProducts);
	}
	
	@Test @Ignore
	public void testDeleteProductByProductId() {
		boolean deleteProductByProductId = productService.deleteProductByProductId("1");
		assertTrue(deleteProductByProductId);
	}

}
