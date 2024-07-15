package com.example.demo.services.mappers;

import com.example.demo.entities.Category;
import com.example.demo.services.dtos.requests.category.AddCategoryRequest;
import com.example.demo.services.dtos.requests.category.UpdateCategoryRequest;
import com.example.demo.services.dtos.responses.category.AddCategoryResponse;
import com.example.demo.services.dtos.responses.category.GetAllCategoryResponse;
import com.example.demo.services.dtos.responses.category.GetByIdCategoryResponse;
import com.example.demo.services.dtos.responses.category.UpdateCategoryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);
    Category addCategoryRequestToCategory(AddCategoryRequest request);
    AddCategoryResponse categoryToAddCategoryResponse(Category category);
    Category updateCategoryRequestToCategory(UpdateCategoryRequest request);
    UpdateCategoryResponse categoryToUpdateCategoryResponse(Category category);
    GetAllCategoryResponse categoryToGetAllCategoryResponse(Category category);
    GetByIdCategoryResponse categoryToGetByIdCategoryResponse(Category category);
}
