
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

  // Edits an existing user
  // Throws NotFoundException if the user does not exist
  User editUser(int id, User data) throws NotFoundException;

  // Deletes a user
  // Throws NotFoundExeption if the user does not exist
  User deleteUser(int id) throws NotFoundException;
}