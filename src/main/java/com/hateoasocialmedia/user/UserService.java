package com.hateoasocialmedia.user;

public interface UserService {

    User getUserByHandle(String theHandle);

    User getUserById(long theUserId);
}
