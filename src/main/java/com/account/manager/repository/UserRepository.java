package com.account.manager.repository;

import com.account.manager.model.UserInfo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserInfo, Long> {
  public UserInfo findById(Integer id);

  public UserInfo findByUserNameAndEnabled(String username, short enabled);

  @Override
  public UserInfo save(UserInfo userInfo);
};
