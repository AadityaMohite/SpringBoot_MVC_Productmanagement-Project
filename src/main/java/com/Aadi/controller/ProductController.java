package com.Aadi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Aadi.Service.ProductService;
import com.Aadi.entity.Product;

import jakarta.validation.Valid;


@Controller
public class ProductController {

	
	@Autowired
	ProductService productService;
	
	@GetMapping("/product-form")
	public String productform(Model model){
		
		Product product = new Product();
		  model.addAttribute("product", product);
		
		
		return "Product-form";
	}
	@GetMapping("/Products")
	public String AllProducts(Model model) {
		

               List<Product>  products    =     productService.getAllProducts();
	
	             model.addAttribute("Products", products);
	
	
	
		
		return "Products";
		
	}
	
	
	@PostMapping("/save")
	public String saveProduct( @Valid Product product,BindingResult result,Model model,RedirectAttributes attributes) {
	
		System.out.println(result.hasErrors());
		if (result.hasErrors()) {
			
			System.err.println(result);
			
			return "Product-form";
		}
		
		
	       productService.SaveProduct(product);
		      
       attributes.addFlashAttribute("msg", "Product Save Sucessfully");
	
		return "redirect:/Products";
		
	}
	
	
	
	
	
	
	
}
