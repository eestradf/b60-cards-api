package com.example.cardsapi.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class CreditCard {
  private String id;
  private String customerId;
  private CustomerType customerType;
  private String cardNumber;
  private BigDecimal creditLimit;
  private BigDecimal currentBalance;
  private BigDecimal interestRate;
  private LocalDate expirationDate;
  private Boolean isActivate;
}
