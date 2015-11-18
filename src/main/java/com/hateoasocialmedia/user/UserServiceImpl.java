package com.hateoasocialmedia.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserByHandle(String handle) {
        return userRepository.findByHandle(handle);
    }

    @Override
    public User getUserById(long theUserId) {
        return userRepository.findById(theUserId);
    }
}
