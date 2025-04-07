package com.example.cardsapi.infrastructure.repository.document;

import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Getter
@Setter
@Document(collection = "credit")
public class CreditDocument {

  @Id private String id;
  private String customerId;
  private String customerType;
  private BigDecimal creditLimit;
  private BigDecimal outstandingAmount;
  private BigDecimal interestRate;
  private Integer termInMonths;
  private LocalDate startDate;
  private String creditStatus;
  private Boolean isActive;
}
