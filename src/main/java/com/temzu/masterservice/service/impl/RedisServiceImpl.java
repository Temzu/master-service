package com.temzu.masterservice.service.impl;

import com.temzu.masterservice.service.RedisService;
import java.time.Duration;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RedisServiceImpl<T> implements RedisService<T> {

  private final RedisTemplate<String, T> redisTemplate;

  @Override
  public void setWithExpirationTime(String key, T o, Duration duration) {
    redisTemplate.opsForValue().set(key, o, duration);
  }
}
