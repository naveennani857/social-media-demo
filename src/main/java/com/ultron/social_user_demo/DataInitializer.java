package com.ultron.social_user_demo;

import com.ultron.social_user_demo.entities.Post;
import com.ultron.social_user_demo.entities.SocialGroup;
import com.ultron.social_user_demo.entities.SocialProfile;
import com.ultron.social_user_demo.entities.SocialUser;
import com.ultron.social_user_demo.repository.PostRepository;
import com.ultron.social_user_demo.repository.SocialGroupRepository;
import com.ultron.social_user_demo.repository.SocialProfileRepository;
import com.ultron.social_user_demo.repository.SocialUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    private SocialUserRepository socialUserRepository;
    private SocialGroupRepository socialGroupRepository;
    private SocialProfileRepository socialProfileRepository;
    private PostRepository postRepository;

    public DataInitializer(SocialUserRepository socialUserRepository, SocialGroupRepository socialGroupRepository, SocialProfileRepository socialProfileRepository, PostRepository postRepository) {
        this.socialUserRepository = socialUserRepository;
        this.socialGroupRepository = socialGroupRepository;
        this.socialProfileRepository = socialProfileRepository;
        this.postRepository = postRepository;
    }

    @Bean
    public CommandLineRunner initializeData(){
        return args -> {
            //Creating users
            SocialUser user1 = new SocialUser();
            SocialUser user2 = new SocialUser();
            SocialUser user3 = new SocialUser();

            //Saving users into the database
            socialUserRepository.save(user1);
            socialUserRepository.save(user2);
            socialUserRepository.save(user3);

            // Creating Social groups
            SocialGroup group1 = new SocialGroup();
            SocialGroup group2 = new SocialGroup();


            // Adding users into the groups
            group1.getSocialUser().add(user1);
            group1.getSocialUser().add(user2);
            group2.getSocialUser().add(user2);
            group2.getSocialUser().add(user3);
            // saving the groups
            socialGroupRepository.save(group1);
            socialGroupRepository.save(group2);

            //Adding users to groups
            user1.getSocialGroup().add(group1);
            user2.getSocialGroup().add(group1);
            user2.getSocialGroup().add(group2);
            user3.getSocialGroup().add(group2);

            //Saving groups to the database
            socialUserRepository.save(user1);
            socialUserRepository.save(user2);
            socialUserRepository.save(user3);

            //Creating the posts
            Post post1 = new Post();
            Post post2 = new Post();
            Post post3 = new Post();

            //Associate Posts with the users
           post1.setSocialUser(user1);
           post2.setSocialUser(user2);
           post3.setSocialUser(user3);

           // Saving posts to the database
            postRepository.save(post1);
            postRepository.save(post2);
            postRepository.save(post3);

            // Creating some socical profiles
            SocialProfile profile1 = new SocialProfile();
            SocialProfile profile2 = new SocialProfile();
            SocialProfile profile3 = new SocialProfile();

            // Associating profiles with users
            profile1.setSocialUser(user1);
            profile2.setSocialUser(user2);
            profile3.setSocialUser(user3);

            // Saving the profiles to the database
            socialProfileRepository.save(profile1);
            socialProfileRepository.save(profile2);
            socialProfileRepository.save(profile3);
        };
    }

}
