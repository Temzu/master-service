package com.temzu.masterservice.exception.account;

public class AccountWrongCredentialsException extends AccountException {

  private static final String WRONG_PHONE_OR_PASSWORD = "Wrong phone or password entered";

  private AccountWrongCredentialsException() {
    super(WRONG_PHONE_OR_PASSWORD);
  }

  public static AccountWrongCredentialsException byPhoneOrPassword() {
    return new AccountWrongCredentialsException();
  }
}
