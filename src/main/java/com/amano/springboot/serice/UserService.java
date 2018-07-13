package com.amano.springboot.serice;

import com.amano.springboot.model.User;
import com.amano.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // POST
    public boolean createUser(User user) {
        try {
            userRepository.save(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // GET
    public Optional<User> getUser(Long id) {
        return userRepository.findById(id);
    }

    // GET
//    public Optional<User> getUser(String name) {
//        return userRepository.findByName(name);
//    }
//

    // PUT
    public User updateUser(Long id, User user) {
        final Optional<User> fetchedUser = userRepository.findById(id);
        if (fetchedUser.isPresent()) {
            user.setId(id);
            return userRepository.save(user);
        } else {
            return null;
        }
    }

    // PATCH - Update part of entity
    public User patchUser(Long id, User user) {
        final Optional<User> fetchedUser = userRepository.findById(id);
        if (fetchedUser.isPresent()) {
            if (user.getUser_id() != null) {
                fetchedUser.get().setUser_id(user.getUser_id());
            }
            if (user.getName() != null) {
                fetchedUser.get().setName(user.getName());
            }
            if (user.getEmail() != null) {
                fetchedUser.get().setEmail(user.getEmail());
            }
            return userRepository.save(fetchedUser.get());
        } else {
            return null;
        }
    }

    // DELETE
    public boolean deleteUser(Long id) {
        final Optional<User> fetchedUser = userRepository.findById(id);
        if (fetchedUser.isPresent()) {
            userRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

}
