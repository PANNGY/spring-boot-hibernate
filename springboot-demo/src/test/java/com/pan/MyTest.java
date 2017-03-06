package com.pan;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pan.entity.Product;
import com.pan.mapper.ProductMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class MyTest {

	@Autowired 
	ProductMapper productMapper;
	
	@Test
	public void test(){	
		Product product = new Product(1, "test_name", "fact_test", ColourEnum.green);
		productMapper.update(product);
		System.out.println(productMapper.findAll());
	}
}
