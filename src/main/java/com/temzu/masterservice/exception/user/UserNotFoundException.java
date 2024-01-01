package com.temzu.masterservice.exception.user;

public class UserNotFoundException extends UserException {

  private static final String NOT_FOUND = "user not found by %s: %s";

  private UserNotFoundException(String type, String value) {
    super(String.format(NOT_FOUND, type, value));
  }

  public static UserNotFoundException byUid(String uid) {
    return new UserNotFoundException("uid", uid);
  }
}
