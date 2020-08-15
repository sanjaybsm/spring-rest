package com.sanjay.springrest.springrest.rest;

import com.sanjay.springrest.springrest.model.Users;
import com.sanjay.springrest.springrest.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/users")
public class LoginController {

    @Autowired
    LoginService loginService;

    @GetMapping("/all")
    public ResponseEntity getAllUsers() {
        log.debug("Inside GetAll users");
        return new ResponseEntity(loginService.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity addUsers(@RequestBody Users user) {
        log.debug("Inside add all users");
        loginService.addUser(user.getEmail(), user.getPassword());
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity getUser(@RequestParam String email) {
        log.debug("Inside Get user {}", email);
        return new ResponseEntity(loginService.getUser(email), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity deleteUser(@RequestParam("emailId") String email) {
        log.debug("Delete user {}", email);
        loginService.deleteUser(email);
        return new ResponseEntity(HttpStatus.OK);
    }


}
