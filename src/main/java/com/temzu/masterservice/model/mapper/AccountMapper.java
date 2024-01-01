package com.temzu.masterservice.model.mapper;

import com.temzu.masterservice.model.entity.Account;
import com.temzu.masterservice.model.dto.AuthRequest;
import com.temzu.masterservice.model.dto.AccountView;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AccountMapper {

  private final ModelMapper mapper;

  public AccountView toDto(Account account) {
    return mapper.map(account, AccountView.class);
  }

  public Account toEntity(AccountView user) {
    return mapper.map(user, Account.class);
  }

  public Account toEntity(AuthRequest request) {
    return mapper.map(request, Account.class);
  }
}
