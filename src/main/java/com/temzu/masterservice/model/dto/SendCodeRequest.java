package com.temzu.masterservice.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class SendCodeRequest {

  @NotBlank(message = "Phone must not be blank and not be null")
  @Size(min = 11, max = 11, message = "Phone length must be 11")
  @Pattern(regexp="^\\d*$", message = "Phone contains invalid characters")
  private String phone;

}
