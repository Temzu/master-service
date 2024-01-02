package com.temzu.masterservice.service;

import com.temzu.masterservice.config.CustomUserDetails;

public interface TokenService {

  String generateTokenWithExpirationTime(CustomUserDetails user, Integer ttl);

}
