package com.springboot.project.blog.controller;

import com.springboot.project.blog.dto_data_transfer_object.BlogPostDto;
import com.springboot.project.blog.service.BlogPostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class HomeController {

    // in this example we used constructor-based dependency injection. that's why we didn't have to use @AutoWired annotation.
    private final BlogPostService blogPostService;

    public HomeController(BlogPostService blogPostService) {
        this.blogPostService = blogPostService;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<BlogPostDto> posts = blogPostService.getAllPosts(); // Fetch posts
        model.addAttribute("posts", posts);
        model.addAttribute("pageTitle", "Home");
        return "home";
    }


//    @GetMapping("/")
//    public String home(Model model) {
//        model.addAttribute("username", "User");
//        return "index";
//    }

//    @GetMapping("/")
//    public String home(Model model) {
//        model.addAttribute("pageTitle", "Home");
//        return "home";
//    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("pageTitle", "About");
        return "about";
    }

}
