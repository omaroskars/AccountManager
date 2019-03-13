package com.account.manager.controller;

import com.account.manager.service.IUserService;
import com.account.manager.exception.NotFoundException;
import com.account.manager.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Controller for users
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

  @Autowired
  private IUserService service;

  /**
   * Returns a list of all users
   */
  @GetMapping()
  public List<User> getUsers() {
    return service.getAllUsers();
  }

  /**
   * Returns a user specified by id
   */
  @GetMapping(value = "/{id}")
  public ResponseEntity<User> getUser(@PathVariable int id) throws NotFoundException {
    return ResponseEntity.ok().body(service.getUserById(id));
  }

  /**
   * Creates a new user
   */
  @PostMapping()
  public ResponseEntity<User> createUser(@Valid @RequestBody User user) throws URISyntaxException {
    User newUser = service.createUser(user);
    URI location = new URI("/api/user/" + newUser.getId());
    return ResponseEntity.created(location).body(user);
  }

  /**
   * Edits an existing user
   */
  @PutMapping(value = "/{id}")
  public ResponseEntity<User> putUser(@PathVariable int id, @RequestBody User data) throws NotFoundException {
    return ResponseEntity.ok().body(service.editUser(id, data));
  }

  /**
   * Deletes a user
   */
  @DeleteMapping(value = "/{id}")
  public ResponseEntity<User> deleteUser(@PathVariable int id) throws NotFoundException {
    return ResponseEntity.ok().body(service.deleteUser(id));
  }
}