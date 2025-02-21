package com.codewithkansal.Blog_Application.service.Impl;

import com.codewithkansal.Blog_Application.entity.Category;
import com.codewithkansal.Blog_Application.exception.ResourceNotFoundException;
import com.codewithkansal.Blog_Application.mapper.CategoryMapper;
import com.codewithkansal.Blog_Application.payload.CategoryDTO;
import com.codewithkansal.Blog_Application.repository.CategoryRepository;
import com.codewithkansal.Blog_Application.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.codewithkansal.Blog_Application.mapper.CategoryMapper.mapToDTO;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryDTO addCategory(CategoryDTO categoryDTO) {
        //convert DTO into entity
        Category category= CategoryMapper.mapToEntity(categoryDTO);
        Category newCategory=categoryRepository.save(category);
        return mapToDTO(newCategory);
    }

    @Override
    public CategoryDTO getCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryId));

        return mapToDTO(category);
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();

        return categories.stream()
                .map(CategoryMapper::mapToDTO) // Use method reference to simplify code
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDTO updateCategory(CategoryDTO categoryDTO, Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryId));

        category.setName(categoryDTO.getName());
        category.setDescription(categoryDTO.getDescription());
        category.setId(categoryId);

        Category updatedCategory = categoryRepository.save(category);

        return mapToDTO(updatedCategory);
    }

    @Override
    public void deleteCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryId));

        categoryRepository.delete(category);
    }
}
