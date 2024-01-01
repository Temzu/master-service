package com.temzu.masterservice.exception.user;

public class AccountNotFoundException extends AccountException {

  private static final String NOT_FOUND = "account not found by %s: %s";

  private AccountNotFoundException(String type, String value) {
    super(String.format(NOT_FOUND, type, value));
  }

  public static AccountNotFoundException byUid(String uid) {
    return new AccountNotFoundException("uid", uid);
  }
}
