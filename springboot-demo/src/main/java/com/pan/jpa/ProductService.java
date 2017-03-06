package com.pan.jpa;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pan.entity.Product;

@Service
public class ProductService {

	@Autowired
	private ProductRepostory productRepostory;
	
	/**添加事务*/
	@Transactional
	public void inserts(List<Product> products){
		for(Product each:products){
			productRepostory.save(each);
		}
	}
}
