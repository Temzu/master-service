package com.temzu.masterservice.exception.handler;

import com.temzu.masterservice.exception.MasterServiceError;
import com.temzu.masterservice.exception.account.AccountWrongCredentialsException;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BadRequestExceptionHandler {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException ex) {
    List<String> messages =
        ex.getAllErrors().stream()
            .map(DefaultMessageSourceResolvable::getDefaultMessage)
            .collect(Collectors.toList());
    return new ResponseEntity<>(new MasterServiceError(messages), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(AccountWrongCredentialsException.class)
  public ResponseEntity<?> catchAccountWrongCredentialsException(
      AccountWrongCredentialsException ex) {
    return new ResponseEntity<>(new MasterServiceError(ex.getMessage()), HttpStatus.BAD_REQUEST);
  }
}
