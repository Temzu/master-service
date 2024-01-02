package com.temzu.masterservice.service;

import com.temzu.masterservice.model.dto.SendCodeRequest;
import com.temzu.masterservice.model.dto.SendCodeResponse;

public interface SendCodeService {

  SendCodeResponse sendCode(SendCodeRequest request);
}
