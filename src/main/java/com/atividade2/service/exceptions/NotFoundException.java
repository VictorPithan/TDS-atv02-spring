package com.atividade2.service.exceptions;

public class NotFoundException extends RuntimeException {
  public NotFoundException(String message, int id) {
    super(message);
}

  public NotFoundException(String message) {
      super(message);
  }
}
