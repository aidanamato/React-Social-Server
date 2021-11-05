package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.revature.models.Profile;
import com.revature.models.User;
import com.revature.repositories.ProfileRepository;
import com.revature.repositories.UserRepository;

@Service
public class UserService {

    final private UserRepository userRepository;
    private ProfileRepository profileRepository;

    @Autowired
    UserService(UserRepository userRepository, ProfileRepository profileRepository) {
        this.userRepository = userRepository;
        this.profileRepository = profileRepository;
    }

    public void registerUser(User user) {
        userRepository.save(user);
        Profile profile = new Profile();
        profile.setUser(user);
		profileRepository.save(profile);
    }
}
