package com.account.manager.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
@DataJpaTest
public class UserControllerTest {
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
    exception.expect(NotFoundException.class);
    exception.expectMessage("User not found with id: 1");

    service.getUserById(1);
  }

}