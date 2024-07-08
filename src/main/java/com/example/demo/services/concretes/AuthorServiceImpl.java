package com.example.demo.services.concretes;

import com.example.demo.entities.Author;
import com.example.demo.repositories.AuthorRepository;
import com.example.demo.services.abstracts.AuthorService;
import com.example.demo.services.dtos.requests.author.AddAuthorRequest;
import com.example.demo.services.dtos.requests.author.UpdateAuthorRequest;
import com.example.demo.services.dtos.responses.author.AddAuthorResponse;
import com.example.demo.services.dtos.responses.author.GetAllAuthorResponse;
import com.example.demo.services.dtos.responses.author.GetByIdAuthorResponse;
import com.example.demo.services.dtos.responses.author.UpdateAuthorResponse;
import com.example.demo.services.mappers.AuthorMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {
    private AuthorRepository authorRepository;
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<GetAllAuthorResponse> getAllAuthor() {
        List<Author> authors= authorRepository.findAll();
        return authors.stream()
                .map(AuthorMapper.INSTANCE::authorToGetAllAuthorResponse)
                .collect(Collectors.toList());
    }
    @Override
    public GetByIdAuthorResponse getAuthorById(int id) {
        Author author=authorRepository.findById(id).orElseThrow(()->new RuntimeException("Author not found"));
        return AuthorMapper.INSTANCE.authorToGetByIdAuthorResponse(author);
    }
    @Override
    public AddAuthorResponse createAuthor(AddAuthorRequest request) {
        Author author=AuthorMapper.INSTANCE.addAuthorRequestToAuthor(request);
        Author savedAuthor=authorRepository.save(author);
        return AuthorMapper.INSTANCE.authorToAddAuthorResponse(savedAuthor);
    }
    @Override
    public UpdateAuthorResponse updateAuthor(UpdateAuthorRequest request) {
        Author author=AuthorMapper.INSTANCE.updateAuthorRequestToAuthor(request);
        Author updatedAuthor=authorRepository.save(author);
        return AuthorMapper.INSTANCE.authorToUpdateAuthorResponse(updatedAuthor);
    }
    @Override
    public void deleteAuthor(int id) {
        authorRepository.deleteById(id);
    }
}
