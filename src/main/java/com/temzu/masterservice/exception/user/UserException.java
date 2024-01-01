package com.temzu.masterservice.exception.user;

import com.temzu.masterservice.exception.MasterServiceException;

public abstract class UserException extends MasterServiceException {

  public UserException(String message) {
    super(message);
  }
}
