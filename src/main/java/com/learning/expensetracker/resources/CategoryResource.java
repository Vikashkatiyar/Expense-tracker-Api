package com.learning.expensetracker.resources;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.expensetracker.domain.Category;
import com.learning.expensetracker.services.CategoryService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/categories")
public class CategoryResource {

	@Autowired
	CategoryService categoryService;

	@GetMapping("")
	public ResponseEntity<List<Category>> getAllCategories(HttpServletRequest request) {
		int userId = (Integer) request.getAttribute("userId");
		List<Category> categories = categoryService.fetchAllCategories(userId);
		return new ResponseEntity<>(categories, HttpStatus.OK);

	}

	@GetMapping("/{categoryId}")
	public ResponseEntity<Category> getCategoryById(HttpServletRequest request,
			@PathVariable("categoryId") Integer categoryId) {
		int userId = (Integer) request.getAttribute("userId");
		Category category = categoryService.fetchCategoryById(userId, categoryId);
		return new ResponseEntity<>(category, HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Category> addCategory(HttpServletRequest request,
			@RequestBody Map<String, Object> categoryMap) {
		int userId = (Integer) request.getAttribute("userId");
		String title = (String) categoryMap.get("title");
		String description = (String) categoryMap.get("description");
		Category category = categoryService.addCategory(userId, title, description);
		return new ResponseEntity<>(category, HttpStatus.CREATED);
	}

	@PutMapping("/{categoryId}")
	public ResponseEntity<Map<String, Boolean>> updateCategory(HttpServletRequest request,
			@PathVariable("categoryId") Integer categoryId, @RequestBody Category category) {
		int userId = (Integer) request.getAttribute("userId");
		categoryService.updateCategory(userId, categoryId, category);
		Map<String, Boolean> map = new HashMap<>();
		map.put("success", true);
		return new ResponseEntity<>(map, HttpStatus.OK);

	}

	@DeleteMapping("/{categoryId}")
	public ResponseEntity<Map<String, Boolean>> deleteCategory(HttpServletRequest request,
			@PathVariable("categoryId") Integer categoryId) {
		int userId = (Integer) request.getAttribute("userId");
		categoryService.removeCategoryWithAllTransactions(userId, categoryId);
		Map<String, Boolean> map = new HashMap<>();
		map.put("success", true);
		return new ResponseEntity<>(map, HttpStatus.OK);
	}

}
