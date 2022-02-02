package com.store.store.service;

import com.store.store.model.Product;
import com.store.store.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
	@Autowired
	private ProductRepository repo;
	
	//Local Product
    private Product productToUpdate;
	
	public List<Product> fetchProductsList(){
		return repo.findAll();		
	}
	
	public Product saveProductsToDB(Product product) {
		return repo.save(product);
	}
	
	public Optional<Product> fetchProductsById(int id) {
		return repo.findById(id);
	}
	
	@SuppressWarnings("deprecation")
	public String updateProductInRepository(Product product) {
        try {
            productToUpdate = repo.getOne(product.getId());

            productToUpdate.setName(product.getName());
            productToUpdate.setDescription(product.getDescription());
            productToUpdate.setPrice(product.getPrice());
            repo.save(productToUpdate);
            return "Product Updated";
        }catch (Exception e){
            return "There is no product registered under the ID: "+product.getId()+"\nMake sure you you send a valid product!";
        }
    }
	
	
	public String deleteProductsById(int id) {
		try {
			repo.deleteById(id);
			return "Product Successfully Deleted";
		}catch (Exception e) {
			return "Product not found";
		}
	}

}