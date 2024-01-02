package com.temzu.masterservice.service.impl;

import com.temzu.masterservice.model.dto.AccountSaveDto;
import com.temzu.masterservice.model.entity.Account;
import com.temzu.masterservice.exception.account.AccountNotFoundException;
import com.temzu.masterservice.model.dto.AccountView;
import com.temzu.masterservice.config.CustomUserDetails;
import com.temzu.masterservice.model.mapper.AccountMapper;
import com.temzu.masterservice.repository.AccountRepository;
import com.temzu.masterservice.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

  private final AccountRepository repository;
  private final AccountMapper mapper;

  @Override
  public AccountView findByUid(String uid) {
    Account account = find(uid);
    return mapper.toView(account);
  }

  @Override
  public AccountView findByPhone(String phone) {
    Account account = repository
        .findByPhone(phone)
        .orElseThrow(() -> AccountNotFoundException.byPhone(phone));
    return mapper.toView(account);
  }

  @Override
  public boolean existsByPhoneAndPassword(String phone, String password) {
    return repository.existsByPhoneAndPassword(phone, password);
  }

  @Override
  public boolean existsByPhone(String phone) {
    return repository.existsByPhone(phone);
  }

  @Override
  public AccountView save(AccountSaveDto user) {
    Account found = find(user.getUid());
    found.setFirstname(user.getFirstname());
    found.setSurname(user.getSurname());
    return mapper.toView(found);
  }

  @Override
  public UserDetailsService getUserDetailsService() {
    return uid -> mapper.toUserDetails(find(uid));
  }

  private Account find(String uid) {
    return repository
        .findById(uid)
        .orElseThrow(() -> AccountNotFoundException.byUid(uid));
  }

}
