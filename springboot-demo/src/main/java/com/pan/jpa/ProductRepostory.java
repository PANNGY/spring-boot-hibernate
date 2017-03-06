package com.pan.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pan.entity.Product;

public interface ProductRepostory extends JpaRepository<Product, Integer>{

	/**
	 * 按属性查询格式
	 * @param name
	 * @return
	 */
	List<Product> findByName(String name);
}
