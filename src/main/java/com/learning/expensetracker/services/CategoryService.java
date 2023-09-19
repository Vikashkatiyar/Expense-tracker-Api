package com.learning.expensetracker.services;

import java.util.List;

import com.learning.expensetracker.domain.Category;
import com.learning.expensetracker.exceptions.EtBadRequestException;
import com.learning.expensetracker.exceptions.EtResourceNotFoundException;

public interface CategoryService {
   
	List<Category> fetchAllCategories(Integer userId);
	
	Category fetchCategoryById(Integer userId, Integer categoryId) throws EtResourceNotFoundException;
	
	Category addCategory(Integer userId,String title, String description) throws EtBadRequestException;
	
	void updateCategory(Integer userId,Integer categoryId, Category category) throws EtBadRequestException;
	
	void removeCategoryWithAllTransactions(Integer userId, Integer categoryId) throws EtResourceNotFoundException;
	
	
}
