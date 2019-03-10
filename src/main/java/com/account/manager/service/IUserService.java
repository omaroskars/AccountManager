
package com.account.manager.service;

import java.util.List;

import com.account.manager.exception.NotFoundException;
import com.account.manager.model.User;

public interface IUserService {
  // Returns a list of all users
  List<User> getAllUsers();

  // Returns a user speficied by id
  // Throws NotFoundException if user does not exist
  User getUserById(int id) throws NotFoundException;

  // Creates a new user
  User createUser(User user);
}