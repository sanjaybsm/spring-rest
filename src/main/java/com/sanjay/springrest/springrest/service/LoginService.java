package com.sanjay.springrest.springrest.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class LoginService {

    HashMap<String, String> users = new HashMap<>();

    public void addUser(String email, String password) {
        users.put(email, password);
    }

    public void deleteUser(String email) {
        users.remove(email);
    }

    public List<String> getAllUsers() {
        return new ArrayList<>(users.keySet());
    }

    public String getUser(String email) {
        return users.get(email);
    }

}
