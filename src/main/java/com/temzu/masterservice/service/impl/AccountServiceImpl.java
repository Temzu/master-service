package com.temzu.masterservice.service.impl;

import com.temzu.masterservice.model.dto.AccountSaveDto;
import com.temzu.masterservice.model.entity.Account;
import com.temzu.masterservice.exception.account.AccountNotFoundException;
import com.temzu.masterservice.model.dto.AccountView;
import com.temzu.masterservice.model.mapper.AccountMapper;
import com.temzu.masterservice.repository.AccountRepository;
import com.temzu.masterservice.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

  private final AccountRepository repository;
  private final AccountMapper mapper;

  @Override
  public AccountView findByUid(String uid) {
    Account account = find(uid);
    return mapper.toDto(account);
  }

  @Override
  public AccountView save(AccountSaveDto user) {
    Account found = find(user.getUid());
    found.setFirstname(user.getFirstname());
    found.setSurname(user.getSurname());
    return mapper.toDto(found);
  }

  private Account find(String uid) {
    return repository
        .findById(uid)
        .orElseThrow(() -> AccountNotFoundException.byUid(uid));
  }

}
