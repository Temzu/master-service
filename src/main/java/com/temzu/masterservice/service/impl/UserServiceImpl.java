package com.temzu.masterservice.service.impl;

import com.temzu.masterservice.model.dto.UserSaveDto;
import com.temzu.masterservice.model.entity.User;
import com.temzu.masterservice.exception.user.UserNotFoundException;
import com.temzu.masterservice.model.dto.UserView;
import com.temzu.masterservice.model.mapper.UserMapper;
import com.temzu.masterservice.repository.UserRepository;
import com.temzu.masterservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository repository;
  private final UserMapper mapper;

  @Override
  public UserView findByUid(String uid) {
    User user = find(uid);
    return mapper.toDto(user);
  }

  @Override
  public UserView save(UserSaveDto user) {
    User found = find(user.getUid());
    found.setFirstname(user.getFirstname());
    found.setSurname(user.getSurname());
    return mapper.toDto(found);
  }

  private User find(String uid) {
    return repository
        .findById(uid)
        .orElseThrow(() -> UserNotFoundException.byUid(uid));
  }

}
