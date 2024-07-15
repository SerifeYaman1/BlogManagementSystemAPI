package com.example.demo.services.concretes;

import com.example.demo.core.utils.result.DataResult;
import com.example.demo.core.utils.result.Result;
import com.example.demo.core.utils.result.SuccessDataResult;
import com.example.demo.core.utils.result.SuccessResult;
import com.example.demo.entities.Category;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.services.abstracts.CategoryService;
import com.example.demo.services.dtos.requests.category.AddCategoryRequest;
import com.example.demo.services.dtos.requests.category.UpdateCategoryRequest;
import com.example.demo.services.dtos.responses.category.AddCategoryResponse;
import com.example.demo.services.dtos.responses.category.GetAllCategoryResponse;
import com.example.demo.services.dtos.responses.category.GetByIdCategoryResponse;
import com.example.demo.services.dtos.responses.category.UpdateCategoryResponse;
import com.example.demo.services.mappers.CategoryMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    @Override
    public DataResult<List<GetAllCategoryResponse>> getAll() {
        List<Category> categories= categoryRepository.findAll();
        return new SuccessDataResult<>(
                categories.stream()
                        .map(CategoryMapper.INSTANCE::categoryToGetAllCategoryResponse)
                        .collect(Collectors.toList()),"Categories listed successfully"
        );
    }
    @Override
    public DataResult<GetByIdCategoryResponse> getById(int id){
        Category category=categoryRepository
                .findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
        return new SuccessDataResult<>(CategoryMapper.INSTANCE.categoryToGetByIdCategoryResponse(category),"Category found successfully");
    }
    @Override
    public DataResult<AddCategoryResponse> createCategory(AddCategoryRequest request) {
        Category category = CategoryMapper.INSTANCE.addCategoryRequestToCategory(request);
        Category savedCategory = categoryRepository.save(category);
        return new SuccessDataResult<>(CategoryMapper.INSTANCE.categoryToAddCategoryResponse(savedCategory),"Category created successfully");
    }
    @Override
    public DataResult<UpdateCategoryResponse> updateCategory(UpdateCategoryRequest request) {
        Category category = CategoryMapper.INSTANCE.updateCategoryRequestToCategory(request);
        Category updatedCategory = categoryRepository.save(category);
        return new SuccessDataResult<>(CategoryMapper.INSTANCE.categoryToUpdateCategoryResponse(updatedCategory),
                "Category updated successfully");
    }
    @Override
    public Result deleteCategory(int id) {
        categoryRepository.deleteById(id);
        return new SuccessResult("Category deleted successfully");
    }
}
