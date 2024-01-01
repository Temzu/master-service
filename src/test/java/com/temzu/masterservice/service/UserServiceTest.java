package com.temzu.masterservice.service;

import com.temzu.masterservice.model.dto.UserSaveDto;
import com.temzu.masterservice.model.dto.UserView;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest extends ServiceTestBase {

  @Autowired
  private UserService userService;

  @BeforeEach
  void setUp() {
    super.setUp();
  }

  @Test
  void testFindByUid() {
    UserView testUser = getTestUser();
    UserView user = userService.findByUid(getTestUser().getUid());

    assertEquals(testUser.getUid(), user.getUid());
    assertEquals(testUser.getFirstname(), user.getFirstname());
    assertEquals(testUser.getSurname(), user.getSurname());
    assertEquals(testUser.getLogin(), user.getLogin());
    assertEquals(testUser.getEmail(), user.getEmail());
  }

  @Test
  void testFindByUidFail() {
    assertThrows(RuntimeException.class, () -> userService.findByUid("uid"));
  }

  @Test
  void save() {
    UserSaveDto dto = new UserSaveDto();
    dto.setUid(getTestUser().getUid());
    dto.setFirstname("new firstname");
    dto.setSurname("new surname");
    UserView saved = userService.save(dto);

    assertEquals(dto.getFirstname(), saved.getFirstname());
    assertEquals(dto.getSurname(), saved.getSurname());
  }
}