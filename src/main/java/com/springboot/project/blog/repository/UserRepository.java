package com.springboot.project.blog.repository;

import com.springboot.project.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//import javax.persistence.Entity;

//Repositories in Spring Data JPA must be interfaces because:
//
//Spring dynamically generates their implementation.
//It reduces boilerplate code.
//It promotes flexibility and stick with the good design principles like the Open/Closed Principle and Separation of Concerns.
//Since jpa repository is an interface preferring extend to interface from interface more appropriate than extending from class
//also in some cases if we create an interface in a class there is a chance JPA couldn't find it automatically.

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);
//  existsByUsername is jpa repository method. Does this query ->  SELECT COUNT(*) > 0 WHERE fieldName = ?

}
