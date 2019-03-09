package com.account.manager.controller;

import com.account.manager.repository.UserRepository;
import com.account.manager.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RestController
@RequestMapping("/api/users/")
public class UserController {
  @Autowired
  private UserRepository userRepository;

  // Get all users
  @GetMapping(value = "")
  public List<User> getUsers() {
    return userRepository.findAll();
  }

  // Get user by id.
  @GetMapping(value = "{id}")
  public ResponseEntity<User> getUser(@PathVariable Long id) throws Exception {
    User user = userRepository.findById(id).orElseThrow(() -> new Exception("User not found on :: " + id));

    return ResponseEntity.ok().body(user);

  }

}