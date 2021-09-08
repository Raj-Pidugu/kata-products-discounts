package com.kata.products.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kata.products.dtls.ProductDetails;
import com.kata.products.request.ProductRequest;
import com.kata.products.response.ProductResponse;
import com.kata.products.service.ProductService;

@RestController
public class ProductController {
/*We can add logger if we want but for this standalone api i didn't kept since no db no table maintaning for log data*/

	@Autowired
	ProductService serviceObj;

	@PostMapping("/promotions")
	public List<ProductDetails> getPromotions(@RequestBody ProductRequest request) {
		List<ProductDetails> response = new ArrayList<ProductDetails>();
		try {
			response = serviceObj.getpromotions(request);
		} catch (Exception e) {

		}

		return response;

	}

}
