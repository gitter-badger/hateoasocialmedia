package com.hateoasocialmedia.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
public class StatusesController {

    @Autowired
    private StatusesService statuses_service;

    @RequestMapping(value = "/statuses/{user_id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Collection<Resource<Status>> getStatuses(@PathVariable(value = "user_id") Long user_id) {
        List<Resource<Status>> resources = new ArrayList<>();
        for (Status a_status : statuses_service.getStatusList(user_id)) {
            resources.add(StatusesResourceUtil.getStatusResource(a_status));
        }
        return resources;
    }

    @RequestMapping(value = "/statuses/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Resource<Status> getStatus(@PathVariable(value = "id") Long status_id) {
        return StatusesResourceUtil.getStatusResource(statuses_service.getStatus(status_id));
    }

    @RequestMapping(value = "/statuses/{user_id}/{id}",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Resource<Status> updateStatus(@PathVariable(value = "user_id") Long user_id,
                                         @PathVariable(value = "id") Long status_id,
                                         @RequestBody Status updated_status) {
        updated_status.setStatus_id(status_id);
        return StatusesResourceUtil.getStatusResource(statuses_service.updateStatus(user_id, updated_status));
    }

    @RequestMapping(value = "/statuses/{user_id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> deleteStatus(@PathVariable(value = "user_id") Long user_id,
                                          @RequestBody Status updated_status) {
        statuses_service.deleteStatus(user_id, updated_status);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.OK);
    }
}
