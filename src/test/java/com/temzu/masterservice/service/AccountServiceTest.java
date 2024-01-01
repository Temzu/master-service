package com.temzu.masterservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.temzu.masterservice.model.dto.AccountSaveDto;
import com.temzu.masterservice.model.dto.AccountView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class AccountServiceTest extends ServiceTestBase {

  @Autowired
  private AccountService accountService;

  @BeforeEach
  void setUp() {
    super.setUp();
  }

  @Test
  void testFindByUid() {
    AccountView testUser = getTestAccount();
    AccountView user = accountService.findByUid(getTestAccount().getUid());

    assertEquals(testUser.getUid(), user.getUid());
    assertEquals(testUser.getFirstname(), user.getFirstname());
    assertEquals(testUser.getSurname(), user.getSurname());
    assertEquals(testUser.getLogin(), user.getLogin());
    assertEquals(testUser.getEmail(), user.getEmail());
  }

  @Test
  void testFindByUidFail() {
    assertThrows(RuntimeException.class, () -> accountService.findByUid("uid"));
  }

  @Test
  void save() {
    AccountSaveDto dto = new AccountSaveDto();
    dto.setUid(getTestAccount().getUid());
    dto.setFirstname("new firstname");
    dto.setSurname("new surname");
    AccountView saved = accountService.save(dto);

    assertEquals(dto.getFirstname(), saved.getFirstname());
    assertEquals(dto.getSurname(), saved.getSurname());
  }
}