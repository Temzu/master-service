package com.temzu.masterservice.exception.account;

import com.temzu.masterservice.exception.MasterServiceException;

public abstract class AccountException extends MasterServiceException {

  public AccountException(String message) {
    super(message);
  }
}
