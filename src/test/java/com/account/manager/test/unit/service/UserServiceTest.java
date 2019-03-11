package com.account.manager.test.unit.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.account.manager.exception.NotFoundException;
import com.account.manager.model.User;
import com.account.manager.repository.UserRepository;
import com.account.manager.service.UserService;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@RunWith(MockitoJUnitRunner.class)
@DataJpaTest
public class UserServiceTest {
  @Mock
  private UserRepository userRepository;

  @InjectMocks
  private UserService service;

  @Rule
  public final ExpectedException exception = ExpectedException.none();

  @Test
  public void getAllUsers_shouldReturnAllUsers() {
    List<User> users = new ArrayList<User>();
    users.add(new User(1, "Omar", "Oskarsson"));
    users.add(new User(2, "Gummi", "Ben"));
    users.add(new User(3, "Olafur", "Darri"));

    when(userRepository.findAll()).thenReturn(users);

    assertEquals(3, service.getAllUsers().size());
  }

  @Test
  public void getUserById_shouldReturnUserWithCorrectId() throws NotFoundException {
    int id = 1;
    User user = new User(id, "Omar", "Oskarsson");

    when(userRepository.findById(1)).thenReturn(Optional.of(user));

    assertEquals(id, service.getUserById(id).getId());
  }

  @Test()
  public void getUserById_shouldThrowNotFoundException_whenUserDoesNotExist() throws NotFoundException {
    int id = 16;
    exception.expect(NotFoundException.class);
    exception.expectMessage("User not found with id: " + id);

    service.getUserById(id);
  }

  @Test
  public void createUser_shouldCreateNewUser() {
    int id = 6;
    User newUser = new User(id, "Kalli", "Bjarni");

    when(userRepository.save(newUser)).thenReturn(newUser);

    assertEquals(newUser, service.createUser(newUser));
  }

  @Test
  public void editUser_shouldEditAUser() throws NotFoundException {
    int id = 4;
    User userToEdit = new User(id, "Stina", "Bjarnadottir");
    User newData = new User(id, "Stina", "Kristinsdottir");

    when(userRepository.findById(id)).thenReturn(Optional.of(userToEdit));
    when(userRepository.save(userToEdit)).thenReturn(newData);

    assertEquals(newData, service.editUser(id, newData));
  }

  @Test
  public void editUser_shouldThrowNotFoundException() throws NotFoundException {
    int id = 16;
    User userData = new User(id, "Omar", "Oskarsson");
    exception.expect(NotFoundException.class);
    exception.expectMessage("User not found with id:");

    service.editUser(id, userData);
  }

  @Test
  public void deleteUser_shouldDeleteUser() throws NotFoundException {
    int id = 6;
    User userToDelete = new User(1, "Omar", "Oskarsson");

    when(userRepository.findById(id)).thenReturn(Optional.of(userToDelete));

    assertEquals(userToDelete, service.deleteUser(id));
  }

  @Test
  public void deleteUser_shouldThrowExceptionNotFound() throws NotFoundException {
    int id = 16;
    exception.expect(NotFoundException.class);
    exception.expectMessage("User not found with id: " + id);

    service.deleteUser(id);
  }
}