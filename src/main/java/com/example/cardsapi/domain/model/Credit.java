package com.example.cardsapi.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Credit {
  private String id;
  private String customerId;
  private CustomerType customerType;
  private BigDecimal creditLimit;
  private BigDecimal outstandingAmount;
  private BigDecimal interestRate;
  private Integer termInMonths;
  private LocalDate startDate;
  private CreditStatus creditStatus;
  private Boolean isActive;
}
