package com.pan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.pan.ColourEnum;

@Entity
@Table(name="product")
public class Product {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	@Column(name="factory_name",length=10)
	private String factory;
	
	@Column(name="colour")
	@Enumerated(EnumType.STRING)
	private ColourEnum colour;
	
	public Product(){}

	public Product(Integer id, String name, String factory, ColourEnum colour) {
		super();
		this.id = id;
		this.name = name;
		this.factory = factory;
		this.colour = colour;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFactory() {
		return factory;
	}

	public void setFactory(String factory) {
		this.factory = factory;
	}

	public ColourEnum getColour() {
		return colour;
	}

	public void setColour(ColourEnum colour) {
		this.colour = colour;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", factory=" + factory
				+ ", colour=" + colour + "]";
	}
	
}
