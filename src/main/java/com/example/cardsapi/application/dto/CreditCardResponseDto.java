package com.example.cardsapi.application.dto;

import com.example.cardsapi.domain.model.CustomerType;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class CreditCardResponseDto {
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
