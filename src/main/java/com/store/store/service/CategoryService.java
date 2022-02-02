package com.store.store.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.store.model.Category;
import com.store.store.repository.CategoryRepository;


@Service
public class CategoryService {
	@Autowired
	private CategoryRepository repo;
	
	public List<Category> fetchCategoryList(){
		return repo.findAll();		
	}
	
	public Category saveCategoryToDB(Category category) {
		return repo.save(category);
	}
	
	public Optional<Category> fetchCategoryById(int id) {
		return repo.findById(id);
	}
	
	public String deleteCategoryById(int id) {
		String result;
		try {
			repo.deleteById(id);
			result = "Category Successfully Deleted";
		}catch (Exception e) {
			result = "Category with id is not deleted";
		}
		return result;
	}

}
