package com.ultron.social_user_demo.entities;

import jakarta.persistence.*;

import java.util.*;

public class SocialUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @OneToOne(mappedBy = "socialUser")
    private SocialProfile socialProfile;

    // CRITICAL: mappedBy tells Hibernate "the relationship is already handled by the 'user' field in the Post class"
    @OneToMany(mappedBy = "socialUser") // need to provide the class which owns the relationship
    /* @JoinColumn(name = "userId") can only be used in uni-directional relationship
     * this is inefficient cause the hibernate first create the post then update the table with userId */
    private List<Post> posts = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "user_group",                                // name of the 3rd table
            joinColumns = @JoinColumn(name = "user_id"),        // FK of this class
            inverseJoinColumns = @JoinColumn(name = "group_id") // FK for the other class(group)
    )
    private Set<SocialGroup> socialGroup = new HashSet<>();


    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }
}
