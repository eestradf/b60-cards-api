package com.example.cardsapi.application.service;

import com.example.cardsapi.domain.model.CreditCard;
import com.example.cardsapi.domain.port.in.CreditCardUseCase;
import com.example.cardsapi.domain.port.out.CreditCardRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CreditCardService implements CreditCardUseCase {
  private final CreditCardRepositoryPort creditCardRepositoryPort;

  @Override
  public Flux<CreditCard> findAllCreditCards() {
    return this.creditCardRepositoryPort.findAllCreditCards();
  }

  @Override
  public Mono<CreditCard> findCreditCardById(String id) {
    return this.creditCardRepositoryPort.findCreditCardById(id);
  }

  @Override
  public Mono<Void> saveCreditCard(CreditCard creditCard) {
    return this.creditCardRepositoryPort.saveCreditCard(creditCard);
  }

  @Override
  public Mono<Void> updateCreditCard(String id, CreditCard creditCard) {
    return this.creditCardRepositoryPort.updateCreditCard(id, creditCard);
  }

  @Override
  public Mono<Void> activateCreditCard(String id) {
    return this.creditCardRepositoryPort.activateCreditCard(id);
  }

  @Override
  public Mono<Void> deactivateCreditCard(String id) {
    return this.creditCardRepositoryPort.deactivateCreditCard(id);
  }
}
