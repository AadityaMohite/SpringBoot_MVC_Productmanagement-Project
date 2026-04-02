package com.Aadi.Exception;

public class UserNotFoundException extends RuntimeException {
  public UserNotFoundException(String msg) {
	  super(msg);
  }
}
