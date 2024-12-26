package com.springboot.project.blog.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

//import javax.persistence.*;
/* The javax.persistence.* import gives access to various JPA annotations and utilities that allow your
Java classes to interact with a relational database, such as creating tables and mapping Java objects to database rows. */

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "blog_posts")
public class BlogPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 255)
    @Column(name = "title")
    private String title;

//    @Lob  // to store large text data
    @Column(name = "content")
    private String content;

//    @Lob
    @Column(name = "author")
    private String author;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    //    The no-argument constructor is for JPA's internal use (especially for object hydration from the database).
    public BlogPost() {
        this.createdAt = LocalDateTime.now();
    }

    //    The id is typically not part of the constructor because it's managed by JPA (or the database) and automatically
//    assigned during the persistence process. we should focus on setting business-related fields in the constructor,
//    not the technical ones like id.
    public BlogPost(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}

