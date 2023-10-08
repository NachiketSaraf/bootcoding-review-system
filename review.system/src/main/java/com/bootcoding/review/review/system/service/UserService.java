package com.bootcoding.review.review.system.service;

import com.bootcoding.review.review.system.model.User;
import com.bootcoding.review.review.system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public static void use(User user){
        System.out.println(user.getName());
        System.out.println(user.getEmailId());
        System.out.println(user.getNumber());
    }

    public void save(User user) {
        userRepository.save(user);
    }
}
