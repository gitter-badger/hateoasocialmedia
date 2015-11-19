package com.hateoasocialmedia.user;

import com.hateoasocialmedia.status.StatusesController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Controller
public class UsersController {

    @Autowired
    UsersService usersService;

    @RequestMapping(value = "/users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Resource<User>> getUsers() {
        return usersService.getUsers().stream().map(this::getUserResource).collect(Collectors.toList());
    }

    @RequestMapping(value = "/users/{user_id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Resource<User> getUsers(@PathVariable(value = "user_id") Long user_id) {
        return getUserResource(usersService.getUserById(user_id));
    }

    private Resource<User> getUserResource(User theUser) {
        Resource<User> userResource = new Resource<>(theUser);
        userResource.add(linkTo(methodOn(UsersController.class).getUsers(theUser.getUserId())).withSelfRel());
        userResource.add(linkTo(methodOn(StatusesController.class).getStatuses(theUser.getUserId())).withRel("statuses"));
        return userResource;
    }

}
