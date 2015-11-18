package com.hateoasocialmedia.status;

import java.util.LinkedHashSet;

public interface StatusesService {

    Status getStatus(long status_id);

    Status addStatus(long user_id, Status new_status);

    Status updateStatus(long user_id, Status updated_status);

    void deleteStatus(long user_id, Status to_remove);

    LinkedHashSet<Status> getStatusList(long user_id);
}
