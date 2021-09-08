package com.kata.products.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.kata.products.dtls.ProductDetails;
import com.kata.products.dto.Product;
import com.kata.products.request.ProductRequest;
import com.kata.products.response.ProductResponse;
import com.kata.products.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Override
	public List<ProductDetails> getpromotions(ProductRequest request) {
		List<ProductDetails> response = new ArrayList<ProductDetails>();
		List<ProductDetails> productDetails = new ArrayList<ProductDetails>();
		try {
			
			List<Product> productsList =request.getProducts();
			
            long productA_Appears = productsList.stream().filter(a->a.getId().equals("A")).count();
            long productB_Appears =  productsList.stream().filter(a->a.getId().equals("B")).count();
			long productC_Appears =  productsList.stream().filter(a->a.getId().equals("C")).count();
			long productD_Appears =  productsList.stream().filter(a->a.getId().equals("D")).count();
			
			if(productA_Appears > 1) { // validating A if coming more than once
				//do nothing
			}
			else {
				
				/*Without db if i need to show array of records every loop 
				 * added two set of product detail records for x discount(1) and y discount(1)
				 * if we have db we can set/fetch values directly 
				 * 
				 * if needs scalable must & should use db in future
				 *  so that we can maintain some configuration table for adding products and
				 *   map what are applicable also*/
				
				
				
				/*For calculating discount 'x' and 'y' */
				//List<ProductDetails> productDetails = new ArrayList<ProductDetails>();
				ProductDetails productDetail = null;
				
				int a = (int) productA_Appears;
				int m = (int)(productB_Appears + productC_Appears); //if need to add one more product for m in future just use '+' symbol and add
				int n = (int) productD_Appears;
				
				

				if((a == 0 && m == 0 && n == 0)) {//if no specified product mentioned and provided wrong name of products
					productDetail = new ProductDetails();
					productDetail.setId("X");
					productDetail.setQuantity(m);
					productDetails.add(productDetail);
					
					productDetail = new ProductDetails();
					productDetail.setId("Y");
					productDetail.setQuantity(n);
					productDetails.add(productDetail);
					 
				}else if(a == 0 && m == 0 && n == 1) {//if loop having only D product
					productDetail = new ProductDetails();
					productDetail.setId("X");
					productDetail.setQuantity(m);
					productDetails.add(productDetail);
					
					productDetail = new ProductDetails();
					productDetail.setId("Y");
					productDetail.setQuantity(n);
					productDetails.add(productDetail);
				}
				
				else if(a == 0 && m >1 && n == 0 
						|| a == 0 && m >1 && n == 1
						|| a == 0 && m >1 && n>1) { //if m>1 and n value changed when no A product availaible
					productDetail = new ProductDetails();
					productDetail.setId("X");
					productDetail.setQuantity(m);
					productDetails.add(productDetail);
					
					productDetail = new ProductDetails();
					productDetail.setId("Y");
					productDetail.setQuantity(0);
					productDetails.add(productDetail);
				
				
					
					
				}else if(a == 1 && m>1 && n == 0) { 
					productDetail = new ProductDetails();
					productDetail.setId("X");
					productDetail.setQuantity(m);
					productDetails.add(productDetail);
					
					productDetail = new ProductDetails();
					productDetail.setId("Y");
					productDetail.setQuantity(0);
					productDetails.add(productDetail);
				}
				else if(a == 1 && m>1 && n > 1) { 
					productDetail = new ProductDetails();
					productDetail.setId("X");
					productDetail.setQuantity(m);
					productDetails.add(productDetail);
					
					productDetail = new ProductDetails();
					productDetail.setId("Y");
					productDetail.setQuantity(n);
					productDetails.add(productDetail);
				}
				else if(a == 1 && m>1 && n == 1) {
					productDetail = new ProductDetails();
					productDetail.setId("X");
					productDetail.setQuantity(m);
					productDetails.add(productDetail);
					
					productDetail = new ProductDetails();
					productDetail.setId("Y");
					productDetail.setQuantity(1);
					productDetails.add(productDetail);
				}else {
					/*if A ==1 , m == 0 and n alone vary values*/
					if(m==0 && a == 1) { 
						
						if(n == 0) {
							productDetail = new ProductDetails();
							productDetail.setId("X");
							productDetail.setQuantity(0);
							productDetails.add(productDetail);
							
							productDetail = new ProductDetails();
							productDetail.setId("Y");
							productDetail.setQuantity(0);
							productDetails.add(productDetail);
						}else if(n == 1) {
							productDetail = new ProductDetails();
							productDetail.setId("X");
							productDetail.setQuantity(0);
							productDetails.add(productDetail);
							
							productDetail = new ProductDetails();
							productDetail.setId("Y");
							productDetail.setQuantity(1);
							productDetails.add(productDetail);
						}else if(n>1) {
							productDetail = new ProductDetails();
							productDetail.setId("X");
							productDetail.setQuantity(0);
							productDetails.add(productDetail);
							
							productDetail = new ProductDetails();
							productDetail.setId("Y");
							productDetail.setQuantity(n);
							productDetails.add(productDetail);
						}
				}else if(m==1 && a == 1) {
					if(n == 0) {
						productDetail = new ProductDetails();
						productDetail.setId("X");
						productDetail.setQuantity(1);
						productDetails.add(productDetail);
						
						productDetail = new ProductDetails();
						productDetail.setId("Y");
						productDetail.setQuantity(0);
						productDetails.add(productDetail);
					}else if(n == 1) {
						productDetail = new ProductDetails();
						productDetail.setId("X");
						productDetail.setQuantity(1);
						productDetails.add(productDetail);
						
						productDetail = new ProductDetails();
						productDetail.setId("Y");
						productDetail.setQuantity(1);
						productDetails.add(productDetail);
					}else if(n>1) {
						productDetail = new ProductDetails();
						productDetail.setId("X");
						productDetail.setQuantity(1);
						productDetails.add(productDetail);
						
						productDetail = new ProductDetails();
						productDetail.setId("Y");
						productDetail.setQuantity(n);
						productDetails.add(productDetail);
					}
				}
				}					
				
				
				/*
				 * response.setSuccess(true);
				 * response.setMessage("Promotions Listed Successfully");
				 */
				//response.setProducts(productDetails);
			} 

		} catch (Exception e) {
			e.printStackTrace();
		}
		return productDetails;
	}

	
}
