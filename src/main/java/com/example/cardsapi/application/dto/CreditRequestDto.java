package com.example.cardsapi.application.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class CreditRequestDto {
  private String customerId;
  private CustomerType customerType;
  private BigDecimal creditLimit;
  private BigDecimal outstandingAmount;
  private BigDecimal interestRate;
  private Integer termInMonths;
  private LocalDate startDate;
  private CreditStatus creditStatus;
}
