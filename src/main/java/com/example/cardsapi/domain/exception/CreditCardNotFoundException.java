package com.example.cardsapi.domain.exception;

public class CreditCardNotFoundException extends RuntimeException {
  public CreditCardNotFoundException() {
    super("Credit card not found");
  }
}
