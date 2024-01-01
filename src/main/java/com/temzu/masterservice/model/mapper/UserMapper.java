package com.temzu.masterservice.model.mapper;

import com.temzu.masterservice.model.entity.User;
import com.temzu.masterservice.model.dto.AuthRequest;
import com.temzu.masterservice.model.dto.UserView;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper {

  private final ModelMapper mapper;

  public UserView toDto(User user) {
    return mapper.map(user, UserView.class);
  }

  public User toEntity(UserView user) {
    return mapper.map(user, User.class);
  }

  public User toEntity(AuthRequest request) {
    return mapper.map(request, User.class);
  }
}
