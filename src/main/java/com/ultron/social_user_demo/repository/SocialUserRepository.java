package com.ultron.social_user_demo.repository;

import com.ultron.social_user_demo.entities.SocialUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocialUserRepository extends JpaRepository<SocialUser,Integer> {
}
