package com.temzu.masterservice.exception;

public abstract class MasterServiceException extends RuntimeException {

  public MasterServiceException(String message) {
    super(message);
  }
}
