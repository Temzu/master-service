package com.temzu.masterservice.service.impl;

import com.temzu.masterservice.exception.account.AccountWrongCredentialsException;
import com.temzu.masterservice.model.dto.AuthRequest;
import com.temzu.masterservice.model.dto.AuthResponse;
import com.temzu.masterservice.model.entity.Account;
import com.temzu.masterservice.model.mapper.AccountMapper;
import com.temzu.masterservice.service.AccountService;
import com.temzu.masterservice.service.AuthService;
import com.temzu.masterservice.service.SendCodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

  private SendCodeService sendCodeService;
  private AccountService accountService;
  private PasswordEncoder passwordEncoder;
  private AccountMapper accountMapper;

  @Override
  public AuthResponse auth(AuthRequest request) {
    return null;
  }

  @Override
  public void logout(String token) {

  }
}
