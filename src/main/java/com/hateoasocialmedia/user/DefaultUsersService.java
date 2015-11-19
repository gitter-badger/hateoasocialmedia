package com.hateoasocialmedia.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DefaultUsersService implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public List<User> getUsers() {
        return StreamSupport.stream(usersRepository.findAll().spliterator(),false).collect(Collectors.toList());
    }

    @Override
    public User getUserByHandle(String handle) {
        return usersRepository.findByHandle(handle);
    }

    @Override
    public User getUserById(long theUserId) {
        return usersRepository.findById(theUserId);
    }
}
