package com.springboot.project.blog.controller;

//import ch.qos.logback.core.model.Model;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.stereotype.Controller;

import com.springboot.project.blog.dto_data_transfer_object.BlogPostDto;
import com.springboot.project.blog.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/posts")
public class BlogPostController {

    @Autowired
    private BlogPostService blogPostService;

//    @PostMapping("/create")
//    public ResponseEntity<String> createPost(@RequestBody BlogPostDto blogPostDto) {
//        if (blogPostDto.getId() != null) {
//            return ResponseEntity.badRequest().body("ID should not be provided in the request body");
//        }
//        blogPostService.createPost(blogPostDto);
//        return ResponseEntity.ok("Post created successfully");
//    }
    @PostMapping("/create")
    public ResponseEntity<String> createPost(@RequestBody BlogPostDto blogPostDto) {
        try {
            blogPostService.createPost(blogPostDto);
            return ResponseEntity.ok("Post created successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error creating post: " + e.getMessage());
        }
    }

    @GetMapping("/")
    public List<BlogPostDto> getAllPosts() {
        return blogPostService.getAllPosts();
    }

//    @GetMapping("/")
//    public ModelAndView home() {
//        List<BlogPostDto> posts = blogPostService.getAllPosts();
//        ModelAndView mav = new ModelAndView("index");
//        mav.addObject("posts", posts);
//        mav.addObject("pageTitle", "Home");
//        return mav;
//    }
//    @GetMapping("/")
//    public String home(Model model) {
//        List<BlogPostDto> posts = blogPostService.getAllPosts(); // Fetch from service
//        model.addAttribute("posts", posts);
//        model.addAttribute("pageTitle", "Home");
//        return "posts";
//    }

//    @GetMapping("/post/{id}")
//    public String viewPost(@PathVariable Long id, Model model) {
//        BlogPostDto post = blogPostService.getPostById(id); // Fetch from service
//        model.addAttribute("post", post);
//        model.addAttribute("pageTitle", post.getTitle());
//        return "post";
//    }
//    @GetMapping("/post/{id}")
//    public String viewPost(@PathVariable Long id, Model model) {
//        BlogPostDto post = blogPostService.getPostById(id);
//        if (post == null) {
//            return "error/404";
//        }
//        model.addAttribute("post", post);
//        model.addAttribute("pageTitle", post.getTitle());
//        return "post";
//    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("pageTitle", "About");
        return "about";
    }




//    public ResponseEntity<BlogPostDto> createPost(@RequestBody BlogPostDto blogPostDto) {
//        blogPostService.createPost(blogPostDto);
//        return ResponseEntity.status(HttpStatus.CREATED).body(blogPostDto);
//    }

//    public ResponseEntity<String> createPost(@RequestBody BlogPostDto blogPostDto) {
//        blogPostService.createPost(blogPostDto);
//        return ResponseEntity.ok("Blog post created successfully!");
//    }

//    @GetMapping("/")
//    public List<BlogPostDto> getAllPosts() {
//        String loggedInUsername = userService.getLoggedInUsername(); // Get the logged-in user's username
//        return blogPostService.getAllPosts().stream()
//                .map(post -> {
//                    BlogPostDto dto = new BlogPostDto();
//                    dto.setTitle(post.getTitle());
//                    dto.setContent(post.getContent());
//                    dto.setAuthor(post.getAuthor());
//                    dto.setOwnedByLoggedInUser(post.getAuthor().equals(loggedInUsername)); // Mark if the post belongs to the logged-in user
//                    return dto;
//                })
//                .collect(Collectors.toList());
//    }
//    @GetMapping("/")
//    public ResponseEntity<List<BlogPostDto>> getAllPosts() {
//        List<BlogPostDto> posts = blogPostService.getAllPosts();
//        return ResponseEntity.ok(posts);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<BlogPostDto> getPostById(@PathVariable Long id) {
        BlogPostDto post = blogPostService.getPostById(id);
        return ResponseEntity.ok(post);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePost(@PathVariable Long id, @RequestBody BlogPostDto blogPostDto) {
        blogPostService.updatePost(id, blogPostDto);
        return ResponseEntity.ok("Blog post updated successfully!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable Long id) {
        blogPostService.deletePost(id);
        return ResponseEntity.ok("Blog post deleted successfully!");
    }

}
