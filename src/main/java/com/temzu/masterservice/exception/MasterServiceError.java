package com.temzu.masterservice.exception;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MasterServiceError {

  private List<String> messages;
  private LocalDateTime timestamp;

  public MasterServiceError(String message) {
    this(List.of(message));
  }

  public MasterServiceError(String... messages) {
    this(List.of(messages));
  }

  public MasterServiceError(List<String> messages) {
    this.messages = messages;
    this.timestamp = LocalDateTime.now();
  }
}
