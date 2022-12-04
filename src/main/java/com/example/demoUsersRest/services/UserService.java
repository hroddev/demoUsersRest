package com.example.demoUsersRest.services;

import com.example.demoUsersRest.models.User;
import org.jvnet.hk2.annotations.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final List<User> users = new ArrayList<>();
    public List<User> getAllUsers() {
        return users;
    }
    public void add(User user) { users.add(user);}
    public User getUser(String name) {
        for (User user : users) {
            if (user.getName().equalsIgnoreCase(name)){
                return user;
            }
        }
        return null;
    }
}
