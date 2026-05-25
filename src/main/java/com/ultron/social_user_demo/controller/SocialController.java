package com.ultron.social_user_demo.controller;

import com.ultron.social_user_demo.entities.SocialUser;
import com.ultron.social_user_demo.service.SocialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SocialController {
    @Autowired
    private SocialService socialService;

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<SocialUser>> getUsers(){
        return new ResponseEntity<>(socialService.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping("/createUser")
    public ResponseEntity<SocialUser> createUser(@RequestBody SocialUser socialUser){
//        // 1. Manually sync the bidirectional link in Java memory
//        if (socialUser.getSocialProfile() != null) {
//           // System.out.println(socialUser.getSocialProfile());
//            socialUser.getSocialProfile().setSocialUser(socialUser);
//            // 2. CRITICAL: Clear out the manual profile ID passed from Postman
//            socialUser.getSocialProfile().setProfileId(null);
//        }
//        // 3. CRITICAL: Clear out the manual user ID passed from Postman
//        socialUser.setUserId(null);
        return new ResponseEntity<>(socialService.saveUser(socialUser),HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        socialService.deleteUser(id);
        return new ResponseEntity<>("User deleted",HttpStatus.OK);
    }
}
