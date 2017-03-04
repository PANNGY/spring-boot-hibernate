package com.pan;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

	@Value("${content}")
	private String content;
	
	@Autowired
	private ProductRepostory productRepostory;
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="/hello",method=RequestMethod.GET)
	public String hello(){
		return content;
	}

	@RequestMapping(value="/get/{id}",method=RequestMethod.GET)
	public Product get(@PathVariable(value="id") Integer id){
		return productRepostory.findOne(id); 
	}
	
	@RequestMapping(value="/getbyname/{name}",method=RequestMethod.GET)
	public List<Product> getByName(@PathVariable(value="name") String name){
		return productRepostory.findByName(name); 
	}
	
	@RequestMapping(value="/getAll",method=RequestMethod.GET)
	public List<Product> getAll(){
		return productRepostory.findAll();
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public Product save(@RequestParam(name="id",required=true) Integer id,
			            @RequestParam(name="name",required=true) String name,
			            @RequestParam(name="factory",required=true) String factory){
	    Product product = new Product();
	    product.setId(id);
	    product.setName(name);
	    product.setFactory(factory);
	    return productRepostory.save(product);		
	}
	
	@RequestMapping(value="/saves",method=RequestMethod.GET)
	public String saves(){
	    Product product = new Product();
	    product.setId(1);
	    product.setName("name1");
	    product.setFactory("factory1");
	    Product product2 = new Product();
	    product2.setId(5);
	    product2.setName("name5");
	    product2.setFactory("factory5");
	    List<Product> products = new ArrayList<Product>();
	    products.add(product);
	    products.add(product2);
	    productService.inserts(products);	
	    return "true";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public Product update(@RequestParam(name="id",required=true) Integer id,
			            @RequestParam(name="name",required=true) String name,
			            @RequestParam(name="factory",required=true) String factory){
	    Product product = new Product();
	    product.setId(id);
	    product.setName(name);
	    product.setFactory(factory);
	    return productRepostory.save(product);	
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
	public String delete(@PathVariable(value="id") Integer id){
		 productRepostory.delete(id);
		 return "true";
	}
}
