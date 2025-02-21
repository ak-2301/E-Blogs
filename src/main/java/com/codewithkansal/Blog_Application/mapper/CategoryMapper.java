package com.codewithkansal.Blog_Application.mapper;

import com.codewithkansal.Blog_Application.entity.Category;
import com.codewithkansal.Blog_Application.payload.CategoryDTO;

public class CategoryMapper {
    // Convert Entity to DTO
    public static CategoryDTO mapToDTO(Category category) {
        if (category == null) {
            return null;
        }

        CategoryDTO categoryDto = new CategoryDTO();
        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());
        categoryDto.setDescription(category.getDescription());

        return categoryDto;
    }

    // Convert DTO to Entity
    public static Category mapToEntity(CategoryDTO categoryDto) {
        if (categoryDto == null) {
            return null;
        }

        Category category = new Category();
        category.setId(categoryDto.getId()); // Only set if updating; can skip for new entities
        category.setName(categoryDto.getName());
        category.setDescription(categoryDto.getDescription());

        return category;
    }
}
