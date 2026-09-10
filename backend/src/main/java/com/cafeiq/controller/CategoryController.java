package com.cafeiq.controller;

import com.cafeiq.entity.Category;
import com.cafeiq.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    // GET all categories
    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    // GET category by ID
    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Integer id) {
        return categoryService.getCategoryById(id);
    }

    // POST category
    @PostMapping
    public Category addCategory(@RequestBody Category category) {
        return categoryService.addCategory(category);
    }

    // PUT category
    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable Integer id,
                                   @RequestBody Category updatedCategory) {

        return categoryService.updateCategory(id, updatedCategory);
    }

    // DELETE category
    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable Integer id) {

        categoryService.deleteCategory(id);

        return "Category deleted successfully";
    }
}