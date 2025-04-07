package com.example.cardsapi.application.controller;

import com.example.cardsapi.application.dto.CreditCardRequestDto;
import com.example.cardsapi.application.dto.CreditCardResponseDto;
import com.example.cardsapi.application.mapper.CreditCardInitMapper;
import com.example.cardsapi.domain.model.CreditCard;
import com.example.cardsapi.domain.port.in.CreditCardUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/credit-cards")
@RequiredArgsConstructor
public class CreditCardController {
  private final CreditCardUseCase creditCardUseCase;
  private final CreditCardInitMapper creditCardInitMapper;

  @GetMapping
  public Flux<CreditCardResponseDto> getAllCreditCards() {
    return this.creditCardUseCase
        .findAllCreditCards()
        .map(this.creditCardInitMapper::toCreditCardResponseDto);
  }

  @GetMapping("/{credit-card-id}")
  public Mono<CreditCardResponseDto> getCreditCardById(@PathVariable("credit-card-id") String id) {
    return this.creditCardUseCase
        .findCreditCardById(id)
        .map(this.creditCardInitMapper::toCreditCardResponseDto);
  }

  @PostMapping
  public Mono<Void> createCreditCard(@RequestBody CreditCardRequestDto creditCardRequestDto) {
    CreditCard creditCard = this.creditCardInitMapper.toCreditCard(creditCardRequestDto);
    return this.creditCardUseCase.saveCreditCard(creditCard);
  }

  @PutMapping("/{credit-card-id}")
  public Mono<Void> updateCreditCard(
      @PathVariable("credit-card-id") String id,
      @RequestBody CreditCardRequestDto creditCardRequestDto) {
    CreditCard creditCard = this.creditCardInitMapper.toCreditCard(creditCardRequestDto);
    return this.creditCardUseCase.updateCreditCard(id, creditCard);
  }

  @PutMapping("/{credit-card-id}/activate")
  public Mono<Void> activateCreditCardById(@PathVariable("credit-card-id") String id) {
    return this.creditCardUseCase.activateCreditCard(id);
  }

  @PutMapping("/{credit-card-id}/deactivate")
  public Mono<Void> deactivateCreditCardById(@PathVariable("credit-card-id") String id) {
    return this.creditCardUseCase.deactivateCreditCard(id);
  }
}
