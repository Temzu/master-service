package com.temzu.masterservice.model.mapper;

import com.temzu.masterservice.config.CustomUserDetails;
import com.temzu.masterservice.model.dto.AccountSaveDto;
import com.temzu.masterservice.model.entity.Account;
import com.temzu.masterservice.model.dto.AuthRequest;
import com.temzu.masterservice.model.dto.AccountView;
import com.temzu.masterservice.model.entity.Role;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

  private final ModelMapper mapper;

  public AccountMapper(ModelMapper mapper) {
    this.mapper = mapper;
  }

  public AccountView toView(Account account) {
    return mapper.map(account, AccountView.class);
  }

  public AccountSaveDto toSaveDto(Account account) {
    return mapper.map(account, AccountSaveDto.class);
  }

  public CustomUserDetails toUserDetails(Account account) {
    CustomUserDetails userDetails = mapper.map(account, CustomUserDetails.class);
    account.getRoles().forEach(role -> userDetails.getRoles().add(role.getName()));
    return userDetails;
  }

  public Account toEntity(AccountView user) {
    return mapper.map(user, Account.class);
  }

  public Account toEntity(AuthRequest request) {
    return mapper.map(request, Account.class);
  }
}
