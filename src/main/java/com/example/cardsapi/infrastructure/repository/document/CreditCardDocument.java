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
@Document(collection = "credit_card")
public class CreditCardDocument {
  @Id private String id;
  private String customerId;
  private String customerType;
  private String cardNumber;
  private BigDecimal creditLimit;
  private BigDecimal currentBalance;
  private BigDecimal interestRate;
  private LocalDate expirationDate;
  private Boolean isActivate;
}
