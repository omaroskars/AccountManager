package com.account.manager.service;

import java.util.List;

import com.account.manager.exception.NotFoundException;
import com.account.manager.model.User;
import com.account.manager.repository.UserRepository;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class UserService implements IUserService {
  private UserRepository repository;

  public UserService(UserRepository repository) {
    this.repository = repository;
  }

  public List<User> getAllUsers() {
    return repository.findAll();
  }

  public User getUserById(int id) throws NotFoundException {
    return repository.findById(id).orElseThrow(() -> new NotFoundException("User not found with id: " + id));
  }

  public User createUser(User user) {
    return repository.save(user);
  }
}