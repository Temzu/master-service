package com.temzu.masterservice.model.dto;

import lombok.Data;

@Data
public class UserView {

  private String uid;
  private String login;
  private String email;
  private String firstname;
  private String surname;
  private boolean active;
}
