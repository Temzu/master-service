package com.temzu.masterservice.service;

import com.temzu.masterservice.model.dto.UserView;
import com.temzu.masterservice.model.entity.User;
import com.temzu.masterservice.model.mapper.UserMapper;
import com.temzu.masterservice.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public abstract class ServiceTestBase {

  @Autowired private UserRepository userRepository;
  @Autowired private UserMapper userMapper;
  private UserView testUser;

  @BeforeEach
  void setUp() {
    testUser = userMapper.toDto(userRepository.save(createUser()));
  }

  @AfterEach
  void tearDown() {
    userRepository.deleteById(getTestUser().getUid());
  }

  protected UserView getTestUser() {
    return testUser;
  }

  protected User createUser() {
    User user = new User();
    user.setLogin("testUser");
    user.setEmail("test@gmail.com");
    user.setPassword("123");
    user.setPhone("79001002022");
    user.setFirstname("testName");
    user.setSurname("surname");
    user.setActive(true);
    return user;
  }

}
