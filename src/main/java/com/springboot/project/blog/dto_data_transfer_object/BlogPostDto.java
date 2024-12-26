package com.springboot.project.blog.dto_data_transfer_object;

public class BlogPostDto {
    private String id;
    private String title;
    private String content;
    private String author;
//    private boolean ownedByLoggedInUser;
//    private String summary;


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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

    public void setOwnedByLoggedInUser(boolean equals) {
    }

//    public String getSummary() {
//        return summary;
//    }
//
//    public void setSummary(String summary) {
//        this.summary = summary;
//    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
}
