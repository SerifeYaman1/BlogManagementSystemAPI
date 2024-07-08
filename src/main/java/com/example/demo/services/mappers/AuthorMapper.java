package com.example.demo.services.mappers;

import com.example.demo.entities.Author;
import com.example.demo.services.dtos.requests.author.AddAuthorRequest;
import com.example.demo.services.dtos.requests.author.UpdateAuthorRequest;
import com.example.demo.services.dtos.responses.author.AddAuthorResponse;
import com.example.demo.services.dtos.responses.author.GetAllAuthorResponse;
import com.example.demo.services.dtos.responses.author.GetByIdAuthorResponse;
import com.example.demo.services.dtos.responses.author.UpdateAuthorResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthorMapper {
    AuthorMapper INSTANCE= Mappers.getMapper(AuthorMapper.class);
    Author addAuthorRequestToAuthor(AddAuthorRequest request);
    AddAuthorResponse authorToAddAuthorResponse(Author author);
    Author updateAuthorRequestToAuthor(UpdateAuthorRequest request);
    UpdateAuthorResponse authorToUpdateAuthorResponse(Author author);
    GetAllAuthorResponse authorToGetAllAuthorResponse(Author author);
    GetByIdAuthorResponse authorToGetByIdAuthorResponse(Author author);
}
