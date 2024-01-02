package com.temzu.masterservice.service;

import com.temzu.masterservice.model.dto.AuthRequest;
import com.temzu.masterservice.model.dto.AuthResponse;

public interface AuthService {

  AuthResponse auth(AuthRequest request);

  void logout(String token);

}
