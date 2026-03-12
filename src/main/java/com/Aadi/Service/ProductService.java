package com.Aadi.Service;

import java.util.List;

import com.Aadi.entity.Product;

public interface ProductService {

	public abstract void SaveProduct(Product product);
	public abstract List<Product> getAllProducts();
   public abstract Product updateproduct(int id);
   public abstract void deleteproduct(int id);
}
