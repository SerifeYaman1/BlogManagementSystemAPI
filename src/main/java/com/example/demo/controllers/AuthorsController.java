package com.example.demo.controllers;

import com.example.demo.services.abstracts.AuthorService;
import com.example.demo.services.dtos.requests.author.AddAuthorRequest;
import com.example.demo.services.dtos.requests.author.UpdateAuthorRequest;
import com.example.demo.services.dtos.responses.author.AddAuthorResponse;
import com.example.demo.services.dtos.responses.author.GetAllAuthorResponse;
import com.example.demo.services.dtos.responses.author.GetByIdAuthorResponse;
import com.example.demo.services.dtos.responses.author.UpdateAuthorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorsController {
    private AuthorService authorService;
    public AuthorsController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("getAll")
    public List<GetAllAuthorResponse> getAllAuthor(){
        return authorService.getAllAuthor();
    }
    @GetMapping("getById/{id}")
    public GetByIdAuthorResponse getAuthorById(@PathVariable int id){
        return authorService.getAuthorById(id);
    }
    @PostMapping("create")
    public AddAuthorResponse createAuthor (@RequestBody AddAuthorRequest request){
        return authorService.createAuthor(request);
    }
    @PutMapping("update")
    public UpdateAuthorResponse updateAuthor(@RequestBody UpdateAuthorRequest request){
        return authorService.updateAuthor(request);
    }
    @DeleteMapping("delete/{id}")
    public void deleteAuthor(@PathVariable int id){
        authorService.deleteAuthor(id);
    }

}
