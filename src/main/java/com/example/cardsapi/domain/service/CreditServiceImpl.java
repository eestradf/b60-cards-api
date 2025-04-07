package com.example.cardsapi.domain.service;

import com.example.cardsapi.domain.exception.CreditNotFoundException;
import com.example.cardsapi.domain.model.Credit;
import com.example.cardsapi.domain.port.in.CreditUseCase;
import com.example.cardsapi.domain.port.out.CreditRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CreditServiceImpl implements CreditUseCase {
  private final CreditRepositoryPort creditRepositoryPort;

  @Override
  public Flux<Credit> findAllCredits() {
    return this.creditRepositoryPort.findAllCredits();
  }

  @Override
  public Mono<Credit> findCreditById(String id) {
    return this.creditRepositoryPort
        .findCreditById(id)
        .switchIfEmpty(Mono.error(new CreditNotFoundException()));
  }

  @Override
  public Mono<Void> saveCredit(Credit credit) {
    return this.creditRepositoryPort.saveCredit(credit);
  }

  @Override
  public Mono<Void> updateCredit(String id, Credit credit) {
    return this.creditRepositoryPort.updateCredit(id, credit);
  }

  @Override
  public Mono<Void> activateCredit(String id) {
    return this.creditRepositoryPort.activateCredit(id);
  }

  @Override
  public Mono<Void> deactivateCredit(String id) {
    return this.creditRepositoryPort.deactivateCredit(id);
  }
}
