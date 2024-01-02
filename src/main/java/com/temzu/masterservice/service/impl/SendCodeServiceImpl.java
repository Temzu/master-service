package com.temzu.masterservice.service.impl;

import com.temzu.masterservice.exception.account.AccountWrongCredentialsException;
import com.temzu.masterservice.model.dto.AuthResponse;
import com.temzu.masterservice.model.dto.SendCodeRequest;
import com.temzu.masterservice.model.dto.SendCodeResponse;
import com.temzu.masterservice.model.entity.Account;
import com.temzu.masterservice.model.mapper.AccountMapper;
import com.temzu.masterservice.service.AccountService;
import com.temzu.masterservice.service.SendCodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SendCodeServiceImpl implements SendCodeService {

  private AccountService accountService;
  private PasswordEncoder passwordEncoder;
  private AccountMapper accountMapper;


  @Override
  public SendCodeResponse sendCode(SendCodeRequest request) {
    String phone = formatPhone(request.getCountryCode(), request.getPhone());
    String password = passwordEncoder.encode(request.getPassword());
    if (!accountService.existsByPhone(phone)) {
      Account account = new Account();
      account.setActive(false);
      account.setPhone(phone);
      account.setPassword(password);
      accountService.save(accountMapper.toSaveDto(account));
    }
    if (!accountService.existsByPhoneAndPassword(phone, password)) {
      throw AccountWrongCredentialsException.byPhoneOrPassword();
    }

    return null;
  }

  private String formatPhone(String countryCode, String phone) {
    String correctCode = countryCode.replaceAll("\\d", "");
    String correctPhone = phone.replaceAll("\\d", "");
    return correctCode + "|" + correctPhone;
  }
}
