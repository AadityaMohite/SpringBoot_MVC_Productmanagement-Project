package com.Aadi.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Aadi.Service.ProductService;
import com.Aadi.entity.Product;
import com.Aadi.repo.ProductRepository;
import jakarta.validation.Valid;


@Controller
public class ProductController {

	@Autowired
     ProductRepository productRepository ;

	
	@Autowired
	ProductService productService;
	
	@GetMapping("/product-form")
	public String productform(Model model){
		
		Product product = new Product();
		  model.addAttribute("product", product);
		
		
		return "Product-form";
	}
//	@GetMapping("/Products")
//	public String AllProducts(Model model) {
//		
//
//               List<Product>  products    =     productService.getAllProducts();
//	
//	             model.addAttribute("Products", products);
//	
//	
//	
//		
//		return "Products";
//		
//	}
	
	@GetMapping("/Products")
	public String AllProducts(@RequestParam(defaultValue = "1")  int page,Model model) {
		

               PageRequest pageRequest = PageRequest.of(page, 4);
	
	           Page<Product>  productpage  =  	productRepository.findAll(pageRequest);
	           model.addAttribute("Products", productpage);
	           model.addAttribute("currentpage", page);
	           model.addAttribute("totalpages", productpage.getTotalPages());
		
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
	
	
	@GetMapping("/update")
	public String updateproduct( @RequestParam int id , Model  model) {
		
		Product product =	productService.updateproduct(id);
		  
		model.addAttribute("product",product);
	
		
		return "update-form";
	}
	
	
	@PostMapping("/edit")
	public String editproduct(Product product , Model model,RedirectAttributes attributes) {
		
		  productService.SaveProduct(product);
		  attributes.addFlashAttribute("msg", "Product Update Sucessfully");
		
		return "redirect:/Products";
	}
	
	@GetMapping("/delete")
	public String deleteproduct(@RequestParam int id,  Model model,RedirectAttributes attributes) {
	
		                productService.deleteproduct(id);
		      attributes.addFlashAttribute("msg", "Product delete Sucessfully");
		
		
		return "redirect:/Products";
	}
	
	@GetMapping("/access-denied")
    public String accessDenied() {
        return "access-denied";
    }
	
	
	
}
