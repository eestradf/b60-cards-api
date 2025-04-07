package com.example.cardsapi.application.mapper;

import com.example.cardsapi.application.dto.CreditRequestDto;
import com.example.cardsapi.application.dto.CreditResponseDto;
import com.example.cardsapi.domain.model.Credit;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CreditInitMapper {
  CreditResponseDto toCreditResponseDto(Credit credit);

  Credit toCredit(CreditRequestDto creditRequestDto);
}
