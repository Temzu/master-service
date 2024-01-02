package com.temzu.masterservice.service;

import com.temzu.masterservice.model.dto.AccountSaveDto;
import com.temzu.masterservice.model.dto.AccountView;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AccountService {

  AccountView findByUid(String uid);

  AccountView findByPhone(String phone);

  boolean existsByPhoneAndPassword(String phone, String password);

  boolean existsByPhone(String phone);

  AccountView save(AccountSaveDto user);

  UserDetailsService getUserDetailsService();
}
