package com.account.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.account.manager.model.UserInfo;
import com.account.manager.repository.UserRepository;

@Repository
@Transactional
public class UserInfoService {

  @Autowired
  private UserRepository userRepository;

  public UserInfo getUserInfoByUserName(String userName) {
    short enabled = 1;
    return userRepository.findByUserNameAndEnabled(userName, enabled);
  }

  public List<UserInfo> getAllUsers() {
    return userRepository.findAll();
  }

  // public List<UserInfo> getAllActiveUserInfo() {
  // return userRepository.findAllByEnabled((short) 1);
  // }

  public UserInfo getUserInfoById(Integer id) {
    return userRepository.findById(id);
  }

  public UserInfo createUser(UserInfo userInfo) {
    userInfo.setPassword(new BCryptPasswordEncoder().encode(userInfo.getPassword()));
    return userRepository.save(userInfo);
  }

  // public UserInfo updateUser(UserInfo userInfo) {
  // return userRepository.save(userInfo);
  // }

  // public void deleteUser(Integer id) {
  // userRepository.deleteById(id);
  // }
}