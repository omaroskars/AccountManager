package com.account.manager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends Exception {

  private static final long serialVersionUID = 1816499594627091802L;

  public NotFoundException(String message) {
    super(message);
  }
}