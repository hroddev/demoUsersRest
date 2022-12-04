package com.example.demoUsersRest.controllers;

import com.example.demoUsersRest.models.User;
import com.example.demoUsersRest.services.UserService;
import jakarta.ws.rs.*;

import jakarta.ws.rs.core.Response;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.util.List;


@Component
@Path("/")

public class UsersControllers {

    private final UserService userService;

    public UsersControllers() {
        userService = new UserService();
        this.userService.add(new User("User1"));
        this.userService.add(new User("User2"));
        this.userService.add(new User("User3"));

    }

    public UsersControllers(UserService userService) {
        this.userService = userService;
    }


    @GET
    @Path("/users")
    @Produces("application/json")
    public List<User> showUsers(){ return userService.getAllUsers();}

    @GET
    @Path("/users/{name}")
    @Produces("application/json")
    public User showUser(@PathParam("name") String name){return userService.getUser(name);}

    @POST
    @Path("/users")
    @Produces("application/json")
    @Consumes("application/json")
    public Response addUser(User user) {
        userService.add(user);
        return  Response.created(
                URI.create("/users/" + user.getName())
        ).build();
    }
}

