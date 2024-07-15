package com.example.demo.controllers;

import com.example.demo.core.utils.result.DataResult;
import com.example.demo.core.utils.result.Result;
import com.example.demo.services.abstracts.CategoryService;
import com.example.demo.services.dtos.requests.category.AddCategoryRequest;
import com.example.demo.services.dtos.requests.category.UpdateCategoryRequest;
import com.example.demo.services.dtos.responses.category.AddCategoryResponse;
import com.example.demo.services.dtos.responses.category.GetAllCategoryResponse;
import com.example.demo.services.dtos.responses.category.GetByIdCategoryResponse;
import com.example.demo.services.dtos.responses.category.UpdateCategoryResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoriesController {
    private final CategoryService categoryService;

    public CategoriesController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @GetMapping("getAll")
    public DataResult<List<GetAllCategoryResponse>> getAll(){
        return categoryService.getAll();
    }
    @GetMapping("getById")
    public DataResult<GetByIdCategoryResponse> getById(int id){
        return categoryService.getById(id);
    }
    @PostMapping("create")
    public DataResult<AddCategoryResponse> createCategory(AddCategoryRequest request){
        return categoryService.createCategory(request);
    }
    @PutMapping("update")
    public DataResult<UpdateCategoryResponse> updateCategory(UpdateCategoryRequest request){
        return categoryService.updateCategory(request);
    }
    @DeleteMapping("delete")
    public Result deleteCategory(int id){
        return categoryService.deleteCategory(id);
    }
}
