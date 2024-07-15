package com.example.demo.services.abstracts;

import com.example.demo.core.utils.result.DataResult;
import com.example.demo.core.utils.result.Result;
import com.example.demo.entities.Category;
import com.example.demo.services.dtos.requests.category.AddCategoryRequest;
import com.example.demo.services.dtos.requests.category.UpdateCategoryRequest;
import com.example.demo.services.dtos.responses.category.AddCategoryResponse;
import com.example.demo.services.dtos.responses.category.GetAllCategoryResponse;
import com.example.demo.services.dtos.responses.category.GetByIdCategoryResponse;
import com.example.demo.services.dtos.responses.category.UpdateCategoryResponse;

import java.util.List;

public interface CategoryService {
    DataResult<List<GetAllCategoryResponse>> getAll();
    DataResult<GetByIdCategoryResponse> getById(int id);
    DataResult<AddCategoryResponse> createCategory(AddCategoryRequest request);
    DataResult<UpdateCategoryResponse> updateCategory(UpdateCategoryRequest request);
    Result deleteCategory(int id);
}
