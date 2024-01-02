package com.temzu.masterservice.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AccountSaveDto {

  @NotNull(message = "User uid must be not null")
  private String uid;

  @NotBlank(message = "First name must not be blank")
  @NotNull(message = "First name must be not null")
  private String firstname;

  @NotBlank(message = "Surname must not be blank")
  @NotNull(message = "Surname must be not null")
  private String surname;

  private String password;

  private String phone;
}
