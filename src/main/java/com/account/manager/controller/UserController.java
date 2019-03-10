package com.account.manager.controller;

import com.account.manager.repository.UserRepository;
import com.account.manager.exception.NotFoundException;
import com.account.manager.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/users")
public class UserController {
  @Autowired
  private UserRepository repository;

  UserController(UserRepository repository) {
    this.repository = repository;
  }

  // Get all users
  @GetMapping()
  public List<User> getUsers() {
    return repository.findAll();
  }

  // Get user by id.
  @GetMapping(value = "/{id}")
  public ResponseEntity<User> getUser(@PathVariable Long id) throws NotFoundException {
    User user = repository.findById(id).orElseThrow(() -> new NotFoundException("User not found with id: " + id));

    return ResponseEntity.ok().body(user);
  }

  @PostMapping()
  public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
    User newUser = repository.save(user);
    return ResponseEntity.ok().body(newUser);
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<User> putUser(@PathVariable Long id, @RequestBody User newUser) throws NotFoundException {
    return repository.findById(id).map(user -> {
      user.setFirstName(newUser.getFirstName());
      user.setLastName(newUser.getLastName());
      return ResponseEntity.ok().body(repository.save(user));
    }).orElseThrow(() -> new NotFoundException("User not found with id: " + id));
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<User> deleteUser(@PathVariable Long id) throws NotFoundException {
    User user = repository.findById(id).orElseThrow(() -> new NotFoundException("User not found with id: " + id));
    repository.deleteById(id);

    return ResponseEntity.ok().body(user);
  }

}