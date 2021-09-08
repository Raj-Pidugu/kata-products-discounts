package com.kata.products.service;

import java.util.List;

import com.kata.products.dtls.ProductDetails;
import com.kata.products.request.ProductRequest;
import com.kata.products.response.ProductResponse;

public interface ProductService {

	public List<ProductDetails> getpromotions(ProductRequest request);
}
