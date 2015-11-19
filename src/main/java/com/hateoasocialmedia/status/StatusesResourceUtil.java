package com.hateoasocialmedia.status;

import com.hateoasocialmedia.user.UsersController;
import org.springframework.hateoas.Resource;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public class StatusesResourceUtil {

    public static Resource<Status> getStatusResource(Status status) {
        Resource<Status> status_resource = new Resource<>(status);
        status_resource.add(linkTo(methodOn(StatusesController.class).getStatus(status.getStatusId())).withSelfRel());
        status_resource.add(linkTo(methodOn(StatusesController.class).updateStatus(status.getUserId(),
                status.getStatusId(),
                status)).withRel("update"));
        status_resource.add(linkTo(methodOn(StatusesController.class).deleteStatus(status.getUserId(),
                status)).withRel("delete"));
        status_resource.add(linkTo(methodOn(UsersController.class).getUsers(status.getUserId())).withRel("get"));
        return status_resource;
    }
}
