package com.hateoasocialmedia.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StatusesServiceImpl implements StatusesService {

    @Autowired
    private StatusesRepository status_repository;

    @Override
    public LinkedHashSet<Status> getStatusList(long user_id){
        return status_repository.findByUserId(user_id);
    }

    @Override
    public Status addStatus(long user_id, Status new_status){
        return status_repository.save(new_status);
    }

    @Override
    public Status updateStatus(long user_id, Status to_update){
        return status_repository.save(to_update);
    }

    @Override
    public void deleteStatus(long user_id, Status to_remove){
        status_repository.delete(to_remove);
    }

    @Override
    public Status getStatus(long status_id) {
        return status_repository.findByStatusId(status_id);
    }
}
