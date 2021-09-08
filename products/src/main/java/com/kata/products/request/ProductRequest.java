package com.kata.products.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kata.products.dto.Product;

public class ProductRequest {
	@JsonProperty("products")
    public List<Product> products;

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
}
