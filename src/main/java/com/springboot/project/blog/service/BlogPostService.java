package com.springboot.project.blog.service;

import com.springboot.project.blog.dto_data_transfer_object.BlogPostDto;

import java.util.List;

public interface BlogPostService {
    void createPost(BlogPostDto blogPostDto);

    List<BlogPostDto> getAllPosts();

//    List<BlogPostDto> getAllPost();

    BlogPostDto getPostById(Long id);

    void updatePost(Long id, BlogPostDto blogPostDto);

    void deletePost(Long id);

//    String getLoggedInUsername();

}
