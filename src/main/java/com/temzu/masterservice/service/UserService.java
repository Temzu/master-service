package com.temzu.masterservice.service;

import com.temzu.masterservice.model.dto.UserSaveDto;
import com.temzu.masterservice.model.dto.UserView;

public interface UserService {

  UserView findByUid(String uid);

  UserView save(UserSaveDto user);
}
