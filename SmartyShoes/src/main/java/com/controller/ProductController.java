package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Product;
import com.service.ProductService;

@RestController
public class ProductController 
{
	@Autowired
	ProductService productService;
	
	//http:localhost:9090/adminlogin?name=Priyam&pass=1234
	@RequestMapping(value = "adminlogin",method = RequestMethod.GET)
	public String adminLogin(@RequestParam("name")String name,@RequestParam("pass") String pass) 
	{
		if(name.equals("Priyam")&&pass.equals("1234")) 
			return "Welcome " + name ;
		else 
			return "Sorry you are not registered.";
	}
	
	//http://localhost:9090/products
	@RequestMapping(value="products",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Product> getAllProduct()
	{
		return productService.getAllProduct();
	}
	
	
	//http://localhost:9090/storeProduct
	@RequestMapping(value = "storeProduct", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String storeProduct(@RequestBody Product prod)
	{
		return productService.storeProductRecord(prod);
	}
		
	//http://localhost:9090/updateProduct
	@RequestMapping(value = "updateProduct", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String updateProduct(@RequestBody Product prod)
	{
		return productService.updateProductRecord(prod);
	}
		
	//http://localhost:9090/deleteProduct/15
	@RequestMapping(value = "deleteProduct/{id}", method = RequestMethod.DELETE)
	public String deleteProductRecord(@PathVariable("id") int prodId)
	{
		return productService.deleteProductRecord(prodId);
	}
		
	//http://localhost:9090/findProduct/1
	@RequestMapping(value="findProduct/{id}", method=RequestMethod.GET)
	public Product findProductRecordById(@PathVariable("id") int prodId)
	{
		return productService.findProduct(prodId);
	}
	
		
}
