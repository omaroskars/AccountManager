package com.account.manager.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
public class User {
  /**
   * User unique id
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", unique = true, nullable = false)
  private int id; // User unique id

  /**
   * User first name
   */
  @Column(name = "first_name", nullable = false)
  private String firstName;

  /**
   * User last name
   */
  @Column(name = "last_name", nullable = false)
  private String lastName;

  /**
   * Password for the user
   */
  @Column(name = "password", nullable = false)
  private String password;

  /**
   * Empty ctor for JPA
   */
  public User() {
  }

  /**
   * ctor for tests
   */
  public User(int id, String firstName, String lastName) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  /**
   * Returns the id of the user
   */
  public int getId() {
    return id;
  }

  /**
   * Returns user first name
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Set the user last name
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * Return user last name
   */
  public String getLastName() {
    return this.lastName;
  }

  /**
   * Set user last name
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * Set user password
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * Get user password
   */
  public String getPassword() {
    return password;
  }

  /**
   * Overrides the toString method for easy logging
   */
  @Override
  public String toString() {
    return String.format("User[id=%d, firstName='%s', lastName='%s']", id, firstName, lastName);
  }
}