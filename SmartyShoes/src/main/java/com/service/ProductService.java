package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Product;
import com.dao.ProductDao;

@Service
public class ProductService 
{
	@Autowired
	ProductDao productDao;
	
	public List<Product> getAllProduct()
	{
		return productDao.getAllProduct();
	}
	
	public String storeProductRecord(Product prod)
	{
		if(productDao.storeProductRecord(prod))
			return "Stored Successfully";
		else
			return "Record didn't stored.";
	}
	
	public String updateProductRecord(Product prod)
	{
		if(productDao.updateProductRecord(prod)>0)
			return "Record updated succesfully";
		else
			return "Record didn't updated";
	}
	
	public String deleteProductRecord(int id)
	{
		if(productDao.deleteProductRecord(id)>0)
			return "Record deleted successfully.";
		else
			return "Record not present.";
	}
	
	public Product findProduct(int id)
	{
		return productDao.findProductUsingId(id);
	}
	
}
