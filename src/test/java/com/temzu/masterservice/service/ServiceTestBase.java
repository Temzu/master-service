package com.temzu.masterservice.service;

import com.temzu.masterservice.model.dto.AccountView;
import com.temzu.masterservice.model.entity.Account;
import com.temzu.masterservice.model.mapper.AccountMapper;
import com.temzu.masterservice.repository.AccountRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public abstract class ServiceTestBase {

  @Autowired private AccountRepository accountRepository;
  @Autowired private AccountMapper accountMapper;
  private AccountView testAccount;

  @BeforeEach
  void setUp() {
    testAccount = accountMapper.toDto(accountRepository.save(createUser()));
  }

  @AfterEach
  void tearDown() {
    accountRepository.deleteById(getTestAccount().getUid());
  }

  protected AccountView getTestAccount() {
    return testAccount;
  }

  protected Account createUser() {
    Account account = new Account();
    account.setLogin("testUser");
    account.setEmail("test@gmail.com");
    account.setPassword("123");
    account.setPhone("79001002022");
    account.setFirstname("testName");
    account.setSurname("surname");
    account.setActive(true);
    return account;
  }

}
