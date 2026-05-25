package com.ultron.social_user_demo.repository;

import com.ultron.social_user_demo.entities.SocialProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocialProfileRepository extends JpaRepository<SocialProfile,Integer> {
}
