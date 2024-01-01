package com.temzu.masterservice.service;

import com.temzu.masterservice.model.dto.AccountSaveDto;
import com.temzu.masterservice.model.dto.AccountView;

public interface AccountService {

  AccountView findByUid(String uid);

  AccountView save(AccountSaveDto user);
}
