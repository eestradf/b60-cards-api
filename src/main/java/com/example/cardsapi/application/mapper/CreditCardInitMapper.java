package com.example.cardsapi.application.mapper;

import com.example.cardsapi.application.dto.CreditCardRequestDto;
import com.example.cardsapi.application.dto.CreditCardResponseDto;
import com.example.cardsapi.domain.model.CreditCard;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CreditCardInitMapper {
  CreditCardResponseDto toCreditCardResponseDto(CreditCard creditCard);

  CreditCard toCreditCard(CreditCardRequestDto creditCardRequestDto);
}
