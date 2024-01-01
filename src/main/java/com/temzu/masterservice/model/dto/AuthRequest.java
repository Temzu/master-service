package com.temzu.masterservice.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AuthRequest {

//  @NotBlank(message = "Email must not be blank and not be null")
//  @Email
//  private String email;
//
//  @NotBlank(message = "Login must not be blank and not be null")
//  @Size(min = 6, max = 30, message = "Login length must be between 4-30")
//  @Pattern(regexp="^[A-Za-z\\d]*$", message = "Login contains invalid characters")
//  private String login;

  @NotBlank(message = "Phone must not be blank and not be null")
  @Size(min = 11, max = 11, message = "Phone length must be 11")
  @Pattern(regexp="^\\d*$", message = "Phone contains invalid characters")
  private String phone;

  @NotBlank(message = "Password must not be blank and not be null")
  @Size(min = 6, max = 80, message = "Password length must be between 6-80")
  private String password;
}
