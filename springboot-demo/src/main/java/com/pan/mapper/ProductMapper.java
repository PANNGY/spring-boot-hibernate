package com.pan.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.pan.ColourEnum;
import com.pan.entity.Product;

public interface ProductMapper {

	@Select("select * from product")
	@Results({
			@Result(property="id",column="id"),
			@Result(property="name",column="name"),
			@Result(property="factory",column="factory_name"),
			@Result(property="colour",column="colour",javaType=ColourEnum.class)})
	List<Product> findAll();
	
	@Insert("insert into product (name,factory_name,colour) values(#{name},#{factory},#{colour})")
	void insert(Product product);
	
	@Update("update product set name=#{name} where id=#{id}")
	void update(Product product);
	
	@Delete("delete from product where id=#{id}")
	void delete(Integer id);
}
