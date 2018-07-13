package com.amano.springboot.controller;

import com.amano.springboot.model.User;
import com.amano.springboot.serice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping("/restful/api")
public class UserRestController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder builder) {
        boolean flag = userService.createUser(user);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> userList(@PathVariable Long id) {
        Optional<User> user = userService.getUser(id);
        if (user.isPresent()) {
            return new ResponseEntity<User>(user.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
    }

//    @GetMapping("/user/{name}")
//    public ResponseEntity<User> userList(@PathVariable String name) {
//        Optional<User> user = userService.getUser(id);
//        if (user.isPresent()) {
//            return new ResponseEntity<User>(user.get(), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
//        }
//    }
//

    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        User updateUser = userService.updateUser(id, user);
        if (updateUser != null) {
            return new ResponseEntity<User>(updateUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/user/{id}")
    public ResponseEntity<User> patchUser(@PathVariable Long id, @RequestBody User user) {
        User updateUser = userService.patchUser(id, user);
        if (updateUser != null) {
            return new ResponseEntity<User>(updateUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id) {
        if (userService.deleteUser(id)) {
            return new ResponseEntity<User>(HttpStatus.OK);
        } else {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
    }

}
