package com.temzu.masterservice.service;

import java.time.Duration;

public interface RedisService<T> {

  void setWithExpirationTime(String key, T o, Duration duration);

}
