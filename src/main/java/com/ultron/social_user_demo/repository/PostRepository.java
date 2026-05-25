package com.ultron.social_user_demo.repository;

import com.ultron.social_user_demo.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Integer> {
}
