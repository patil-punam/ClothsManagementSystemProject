package com.store.store.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.store.store.model.Category;
import com.store.store.model.Product;
import com.store.store.service.CategoryService;
import com.store.store.service.ProductService;


@RestController
public class AdminController {
	@Autowired
	private CategoryService categoryService;	
	@Autowired
	private ProductService productService;
	
	//Category Section
	
	@GetMapping("/getcategories")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Category> fetchCategoryList(){
		List<Category> categories = new ArrayList<Category>();
		categories = categoryService.fetchCategoryList();
		return categories;
	}
	
	@PostMapping("/addcategory")
	@CrossOrigin(origins = "http://localhost:4200")
	public Category saveCategory(@RequestBody Category category){
		return categoryService.saveCategoryToDB(category);
	}
	
	@GetMapping("/getcategorybyid/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public Category fetchCategoryById(@PathVariable int id){
		return categoryService.fetchCategoryById(id).get();
	}
	
	@GetMapping("/deletecategorybyid/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public String deleteCategoryById(@PathVariable int id){
		return categoryService.deleteCategoryById(id);
	}
	
	
	//Product Section
	
	@GetMapping("/getproductslist")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Product> fetchProductsList(){
		List<Product> products = new ArrayList<Product>();
		//Logic to fetch list from database
		products = productService.fetchProductsList();
		return products;
	}
	
	@PostMapping("/addproducts")
	@CrossOrigin(origins = "http://localhost:4200")
	public Product saveProducts(@RequestBody Product product){
		return productService.saveProductsToDB(product);
	}
	
	@GetMapping("/getproductsbyid/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public Product fetchProductsById(@PathVariable int id){
		return productService.fetchProductsById(id).get();
	}
	
	@PostMapping("/editproduct/:id")
    @CrossOrigin(origins = "http://localhost:4200")
    public String updateProduct(@RequestBody Product product){
       //Logic to get update product from database
        return productService.updateProductInRepository(product);
    }

    @DeleteMapping("/deleteproductsbyid/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public String deleteProductsById(@PathVariable int id){
		return productService.deleteProductsById(id);
	}
    
}
