package com.example.cardsapi.domain.port.out;

import com.example.cardsapi.domain.model.Credit;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CreditRepositoryPort {
  Flux<Credit> findAllCredits();

  Mono<Credit> findCreditById(String id);

  Mono<Void> saveCredit(Credit credit);

  Mono<Void> updateCredit(String id, Credit credit);

  Mono<Void> activateCredit(String id);

  Mono<Void> deactivateCredit(String id);
}
