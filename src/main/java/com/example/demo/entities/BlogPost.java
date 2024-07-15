package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="blog_posts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BlogPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="title")
    private String title;

    @Column(name="release_date")
    private LocalDate releaseDate;

    @Column(name="content_text")
    private String content;

    @ManyToOne
    @JoinColumn(name="authors_id")
    private Author author;

    @OneToMany(mappedBy = "blogPost")
    private List<Comment> comments;

    @OneToMany(mappedBy = "blogPost")
    private List<Like> likes;

    @Column(name="likes_count")
    private int likesCount;

    @Column(name="comments_count")
    private int commentsCount;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;
}
