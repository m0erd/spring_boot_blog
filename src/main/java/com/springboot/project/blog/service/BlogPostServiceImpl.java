package com.springboot.project.blog.service;

import com.springboot.project.blog.dto_data_transfer_object.BlogPostDto;
import com.springboot.project.blog.model.BlogPost;
import com.springboot.project.blog.repository.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogPostServiceImpl implements BlogPostService {

    @Autowired
    private BlogPostRepository blogPostRepository;

    @Override
    public void createPost(BlogPostDto blogPostDto) {
        if (blogPostDto.getTitle() == null || blogPostDto.getContent() == null) {
            throw new IllegalArgumentException("Title and content must not be null");
        }

        BlogPost post = new BlogPost();
        post.setTitle(blogPostDto.getTitle());
        post.setContent(blogPostDto.getContent());
        post.setAuthor(blogPostDto.getAuthor());

        try {
            blogPostRepository.save(post);
        } catch (Exception e) {
            throw new RuntimeException("Error saving the post: " + e.getMessage());
        }
    }


//    @Override
//    public void createPost(BlogPostDto blogPostDto){
//        BlogPost post = new BlogPost();
//        post.setTitle(blogPostDto.getTitle());
//        post.setContent(blogPostDto.getContent());
//        post.setAuthor(blogPostDto.getAuthor());
//        blogPostRepository.save(post);
//    }

//    @Override
//    public List<BlogPostDto> getAllPosts() {
//        return List.of();
//    }


    @Override
    public List<BlogPostDto> getAllPosts() {
        return blogPostRepository.findAll().stream()
                .map(post -> {
                    BlogPostDto dto = new BlogPostDto();
                    dto.setTitle(post.getTitle());
                    dto.setContent(post.getContent());
                    return dto;
                })
                .collect(Collectors.toList());
    }


    @Override
    public BlogPostDto getPostById(Long id) {
        BlogPost post = blogPostRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found"));
        BlogPostDto dto = new BlogPostDto();
        dto.setTitle(post.getTitle());
        dto.setContent(post.getContent());
        return dto;
    }

    @Override
    public void updatePost(Long id, BlogPostDto blogPostDto) {
        BlogPost post = blogPostRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found"));
        post.setTitle(blogPostDto.getTitle());
        post.setContent(blogPostDto.getContent());
        blogPostRepository.save(post);
    }

    @Override
    public void deletePost(Long id) {
        blogPostRepository.deleteById(id);
    }

//    @Override
//    public String getLoggedInUsername() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication != null && authentication.isAuthenticated()) {
//            return authentication.getName();
//        }
//        return null;
//    }


}
