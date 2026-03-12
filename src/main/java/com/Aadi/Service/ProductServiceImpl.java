package com.Aadi.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Aadi.entity.Product;
import com.Aadi.repo.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;
	
	@Override
	public void SaveProduct(Product product) {
		
       productRepository.save(product);
		
	}
	
	
	public List<Product> getAllProducts() {
		
	List<Product> products	=    productRepository.findAll();
		
		return products;
	}


	@Override
	public Product updateproduct(int id) {
		 Optional<Product>   optional =  productRepository.findById(id);
		 Product product = null;
		 if(optional.isPresent()) {
			   product   =  optional.get();
		 }
		 
		return product;
	}


	@Override
	public void deleteproduct(int id) {
		// TODO Auto-generated method stub
		   productRepository.deleteById(id);
	}
	

}
