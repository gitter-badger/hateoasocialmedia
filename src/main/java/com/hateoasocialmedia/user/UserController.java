package com.hateoasocialmedia.user;

import com.hateoasocialmedia.status.StatusesController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Controller
public class UserController {

    @Autowired UserService userService;

    @RequestMapping(value = "/user/{handle}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Resource<User> getUser(@PathVariable(value = "handle") String handle) {
        return getUserResource(handle);
    }

    @RequestMapping(value = "/user/by_id/{user_id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Resource<User> getUser(@PathVariable(value = "user_id") Long user_id) {
        return getUserResource(user_id);
    }

    private Resource<User> getUserResource(String handle) {
        return getUserResource(userService.getUserByHandle(handle));
    }

    private Resource<User> getUserResource(long user_id) {
        return getUserResource(userService.getUserById(user_id));
    }

    private Resource<User> getUserResource(User theUser) {
        Resource<User> aUserResource = new Resource<>(theUser);
        aUserResource.add(linkTo(methodOn(UserController.class).getUser(theUser.getHandle())).withSelfRel());
        aUserResource.add(linkTo(methodOn(StatusesController.class).getStatuses(theUser.getUserId())).withRel("statuses"));
        return aUserResource;
    }

}
