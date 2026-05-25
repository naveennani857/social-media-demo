package com.ultron.social_user_demo.service;

import com.ultron.social_user_demo.entities.SocialUser;
import com.ultron.social_user_demo.repositories.SocialUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocialService {

    @Autowired
    private SocialUserRepository socialUserRepository;

    public List<SocialUser> getAllUsers() {
        return socialUserRepository.findAll();
    }

    public SocialUser saveUser(SocialUser socialUser) {
        return socialUserRepository.save(socialUser);
    }

    public void deleteUser(Long userId) {
        SocialUser socialUser = socialUserRepository.findById((userId))
                .orElseThrow(() -> new RuntimeException("User not found"));
        socialUserRepository.delete(socialUser);
    }
}
