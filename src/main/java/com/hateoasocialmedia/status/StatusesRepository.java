package com.hateoasocialmedia.status;

import org.springframework.data.repository.CrudRepository;

import java.util.LinkedHashSet;

public interface StatusesRepository extends CrudRepository<Status, Long> {
    Status findByStatusId(long status_id);

    LinkedHashSet<Status> findByUserId(long user_id);
}
