package com.example.demo.services.abstracts;

import com.example.demo.services.dtos.requests.author.AddAuthorRequest;
import com.example.demo.services.dtos.requests.author.UpdateAuthorRequest;
import com.example.demo.services.dtos.responses.author.AddAuthorResponse;
import com.example.demo.services.dtos.responses.author.GetAllAuthorResponse;
import com.example.demo.services.dtos.responses.author.GetByIdAuthorResponse;
import com.example.demo.services.dtos.responses.author.UpdateAuthorResponse;

import java.util.List;

public interface AuthorService {

    List<GetAllAuthorResponse> getAllAuthor();
    GetByIdAuthorResponse getAuthorById(int id);
    AddAuthorResponse createAuthor(AddAuthorRequest request);
    UpdateAuthorResponse updateAuthor( UpdateAuthorRequest request);
    void deleteAuthor(int id);
}
