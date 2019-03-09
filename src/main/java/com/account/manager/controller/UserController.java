package com.account.manager.controller;

import com.account.manager.repository.UserRepository;
import com.account.manager.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class UserController {
  @Autowired
  private UserRepository userRepository;

  @GetMapping(value = "/users")
  public List<User> getUsers() {
    return userRepository.findAll();
  }

}