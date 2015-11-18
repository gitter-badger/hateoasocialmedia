package com.hateoasocialmedia.user;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByHandle(String theHandle);

    User findById(Long theId);
}
