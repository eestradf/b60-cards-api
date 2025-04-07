package com.example.cardsapi.infrastructure.repository.mapper;

import com.example.cardsapi.domain.model.CreditCard;
import com.example.cardsapi.domain.model.CustomerType;
import com.example.cardsapi.infrastructure.repository.document.CreditCardDocument;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CreditCardMapper {
  @Mapping(target = "id", source = "id")
  @Mapping(target = "customerId", source = "customerId")
  @Mapping(target = "customerType", source = "customerType")
  @Mapping(target = "cardNumber", source = "cardNumber")
  @Mapping(target = "creditLimit", source = "creditLimit")
  @Mapping(target = "currentBalance", source = "currentBalance")
  @Mapping(target = "interestRate", source = "interestRate")
  @Mapping(target = "expirationDate", source = "expirationDate")
  @Mapping(target = "isActivate", source = "isActivate")
  CreditCard toCreditCard(CreditCardDocument creditCardDocument);

  @Mapping(target = "id", source = "id")
  @Mapping(target = "customerId", source = "customerId")
  @Mapping(target = "customerType", source = "customerType")
  @Mapping(target = "cardNumber", source = "cardNumber")
  @Mapping(target = "creditLimit", source = "creditLimit")
  @Mapping(target = "currentBalance", source = "currentBalance")
  @Mapping(target = "interestRate", source = "interestRate")
  @Mapping(target = "expirationDate", source = "expirationDate")
  @Mapping(target = "isActivate", source = "isActivate")
  CreditCardDocument toCreditCardDocument(CreditCard creditCard);

  default String customerTypeToString(CustomerType customerType) {
    if (customerType == null) {
      return null;
    }
    return customerType.name();
  }

  default CustomerType stringToCustomerType(String customerType) {
    if (customerType == null) {
      return null;
    }
    return CustomerType.valueOf(customerType.toUpperCase());
  }
}
