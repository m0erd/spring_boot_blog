package com.springboot.project.blog.repository;

import com.springboot.project.blog.model.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {
/* -Abstract methods in the repository use a naming convention that Spring Data JPA recognizes and translates into a database query.
-This eliminates the need for manual query writing, streamlining data access operations.
-The connection is that these methods are tied to our entity class fields, allowing Spring Data JPA to
automatically implement them. */
    List<BlogPost> findAll();  // this method does -> SELECT * FROM blog_posts
    /* It retrieves all rows from the table and maps them to Java objects.
    we can extend its functionality with pagination, sorting, or filtering as needed. */

/* we can create custom query like this;
@Query("SELECT p FROM BlogPost p WHERE p.title LIKE %:keyword%")
List<BlogPost> searchByTitleContaining(@Param("keyword") String keyword);
 */

    List<BlogPost> findByTitle(String title);  // Fetch posts with an exact title(String) match.
    List<BlogPost> findByAuthor(String author);

}
