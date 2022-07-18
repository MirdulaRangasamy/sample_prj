package com.sample.sample_prj;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sample.sample_prj.service.ProductService;

@SpringBootTest
class SamplePrjApplicationTests {
	@Autowired
	ProductService psvc;
	
	@Test
	public void testDeleteProduct() {
		assertEquals("Product Not Found...",psvc.deleteProduct(105));
	}

	@Test
	public void testDeleteProduct1()
	{
		assertEquals("Product Deleted Successfully...",psvc.deleteProduct(101));
	}
	

}
