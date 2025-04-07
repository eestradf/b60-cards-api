package com.example.cardsapi.domain.port.in;

import com.example.cardsapi.domain.model.CreditCard;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CreditCardUseCase {
  Flux<CreditCard> findAllCreditCards();

  Mono<CreditCard> findCreditCardById(String id);

  Mono<Void> saveCreditCard(CreditCard creditCard);

  Mono<Void> updateCreditCard(String id, CreditCard creditCard);

  Mono<Void> activateCreditCard(String id);

  Mono<Void> deactivateCreditCard(String id);
}
