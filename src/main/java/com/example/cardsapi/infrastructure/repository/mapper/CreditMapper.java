package com.example.cardsapi.infrastructure.repository.mapper;

import com.example.cardsapi.domain.model.Credit;
import com.example.cardsapi.domain.model.CreditStatus;
import com.example.cardsapi.domain.model.CustomerType;
import com.example.cardsapi.infrastructure.repository.document.CreditDocument;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CreditMapper {

  @Mapping(target = "id", source = "id")
  @Mapping(target = "customerId", source = "customerId")
  @Mapping(target = "customerType", source = "customerType")
  @Mapping(target = "creditLimit", source = "creditLimit")
  @Mapping(target = "outstandingAmount", source = "outstandingAmount")
  @Mapping(target = "interestRate", source = "interestRate")
  @Mapping(target = "termInMonths", source = "termInMonths")
  @Mapping(target = "startDate", source = "startDate")
  @Mapping(target = "creditStatus", source = "creditStatus")
  Credit toCredit(CreditDocument creditDocument);

  @Mapping(target = "id", source = "id")
  @Mapping(target = "customerId", source = "customerId")
  @Mapping(target = "customerType", source = "customerType")
  @Mapping(target = "creditLimit", source = "creditLimit")
  @Mapping(target = "outstandingAmount", source = "outstandingAmount")
  @Mapping(target = "interestRate", source = "interestRate")
  @Mapping(target = "termInMonths", source = "termInMonths")
  @Mapping(target = "startDate", source = "startDate")
  @Mapping(target = "creditStatus", source = "creditStatus")
  CreditDocument toCreditDocument(Credit credit);

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

  default String creditStatusToString(CreditStatus creditStatus) {
    if (creditStatus == null) {
      return null;
    }
    return creditStatus.name();
  }

  default CreditStatus stringToCreditStatus(String creditStatus) {
    if (creditStatus == null) {
      return null;
    }
    return CreditStatus.valueOf(creditStatus.toUpperCase());
  }
}
