package com.hateoasocialmedia.feed;

import com.hateoasocialmedia.status.StatusesResourceUtil;
import com.hateoasocialmedia.status.StatusesService;
import com.hateoasocialmedia.status.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
public class FeedController {

    @Autowired
    private StatusesService statuses_service;

    @RequestMapping(value = "/feed/{user_id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Collection<Resource<Status>> getFeed(@PathVariable(value = "user_id") Long user_id) {
        List<Resource<Status>> resources = new ArrayList<>();
        for (Status a_status : statuses_service.getStatusList(user_id)) {
            resources.add(StatusesResourceUtil.getStatusResource(a_status));
        }
        return resources;
    }
}
