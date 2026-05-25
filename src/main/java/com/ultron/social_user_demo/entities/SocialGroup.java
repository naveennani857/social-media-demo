package com.ultron.social_user_demo.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class SocialGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "socialGroup")
    private Set<SocialUser> socialUser = new HashSet<>();

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }
}
