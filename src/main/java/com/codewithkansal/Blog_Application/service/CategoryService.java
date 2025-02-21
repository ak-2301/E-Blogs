package com.codewithkansal.Blog_Application.service;

import com.codewithkansal.Blog_Application.payload.CategoryDTO;

import java.util.List;

public interface CategoryService {
    CategoryDTO addCategory(CategoryDTO categoryDTO);

    CategoryDTO getCategory(Long categoryId);

    List<CategoryDTO>getAllCategories();

    CategoryDTO updateCategory(CategoryDTO categoryDTO,Long categoryId);

    void deleteCategory(Long categoryId);
}
