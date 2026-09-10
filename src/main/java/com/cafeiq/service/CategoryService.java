package com.cafeiq.service;

import com.cafeiq.entity.Category;
import com.cafeiq.exception.CategoryNotFoundException;
import com.cafeiq.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    // Get all categories
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    // Get category by ID
    public Category getCategoryById(Integer id) {
        return categoryRepository.findById(id)
                .orElseThrow(() ->
                        new CategoryNotFoundException("Category not found"));
    }

    // Add category
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    // Update category
    public Category updateCategory(Integer id, Category updatedCategory) {

        Category existingCategory = categoryRepository.findById(id)
                .orElseThrow(() ->
                        new CategoryNotFoundException("Category not found"));

        existingCategory.setCategoryName(updatedCategory.getCategoryName());
        existingCategory.setDescription(updatedCategory.getDescription());

        return categoryRepository.save(existingCategory);
    }

    // Delete category
    public void deleteCategory(Integer id) {

        if (!categoryRepository.existsById(id)) {
            throw new CategoryNotFoundException("Category not found");
        }

        categoryRepository.deleteById(id);
    }

}