package com.ultron.social_user_demo.entities;

import jakarta.persistence.*;

public class SocialProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long profileId;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    private SocialUser socialUser;
}
