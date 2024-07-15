package com.example.demo.repositories;

import com.example.demo.core.utils.result.DataResult;
import com.example.demo.entities.BlogPost;
import com.example.demo.services.dtos.responses.blogPost.AuthorOrDateTimeFilteredBlogPost;
import com.example.demo.services.dtos.responses.blogPost.GetByIdBlogPostResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface BlogPostRepository extends JpaRepository<BlogPost, Integer> {
    @Query("SELECT new com.example.demo.services.dtos.responses.blogPost.AuthorOrDateTimeFilteredBlogPost(" +
            "bp.id, bp.title, bp.content, author.username, bp.releaseDate) " +
            "FROM BlogPost bp " +
            "JOIN bp.author author " +
            "WHERE author.username = :authorUsername AND bp.releaseDate = :releaseDate")
    DataResult<List<AuthorOrDateTimeFilteredBlogPost>> findByAuthorAndReleaseDate(
            @Param("authorUsername") String authorUsername,
            @Param("releaseDate") LocalDate releaseDate);
    DataResult<List<AuthorOrDateTimeFilteredBlogPost>>findByAuthorUsername (String authorUsername);
    DataResult<List<AuthorOrDateTimeFilteredBlogPost>>findByReleaseDate (LocalDate releaseDate);
    List<BlogPost> findByCategory_NameIgnoreCase(String categoryName);
}



