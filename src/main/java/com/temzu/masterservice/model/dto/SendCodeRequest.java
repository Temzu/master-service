package com.temzu.masterservice.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SendCodeRequest {

  @NotBlank(message = "country code must not be blank and not be null")
  @Pattern(regexp="^\\d*$", message = "phone contains invalid characters")
  private String countryCode;

  @NotBlank(message = "phone must not be blank and not be null")
  @Pattern(regexp="^\\d*$", message = "phone contains invalid characters")
  private String phone;

  @NotBlank(message = "password must not be blank and not be null")
  @Size(min = 6, max = 80, message = "password length must be between 6-80")
  private String password;

}
