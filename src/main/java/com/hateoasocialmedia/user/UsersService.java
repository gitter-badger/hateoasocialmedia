package com.hateoasocialmedia.user;

import java.util.List;

public interface UsersService {

    List<User> getUsers();

    User getUserByHandle(String theHandle);

    User getUserById(long theUserId);
}
