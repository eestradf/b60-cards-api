package com.example.cardsapi.infrastructure.adapter;

import com.example.cardsapi.domain.exception.CreditNotFoundException;
import com.example.cardsapi.domain.model.Credit;
import com.example.cardsapi.domain.port.out.CreditRepositoryPort;
import com.example.cardsapi.infrastructure.repository.CreditRepository;
import com.example.cardsapi.infrastructure.repository.document.CreditDocument;
import com.example.cardsapi.infrastructure.repository.mapper.CreditMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class CreditAdapter implements CreditRepositoryPort {
  private final CreditRepository creditRepository;
  private final CreditMapper creditMapper;

  @Override
  public Flux<Credit> findAllCredits() {
    return this.creditRepository.findAll().map(this.creditMapper::toCredit);
  }

  @Override
  public Mono<Credit> findCreditById(String id) {
    return this.creditRepository.findById(id).map(this.creditMapper::toCredit);
  }

  @Override
  public Mono<Void> saveCredit(Credit credit) {
    CreditDocument creditDocument = this.creditMapper.toCreditDocument(credit);
    creditDocument.setIsActive(Boolean.TRUE);

    return this.creditRepository.save(creditDocument).then();
  }

  @Override
  public Mono<Void> updateCredit(String id, Credit credit) {
    return this.creditRepository
        .findById(id)
        .switchIfEmpty(Mono.error(new CreditNotFoundException()))
        .map(
            existingCreditDocument -> {
              existingCreditDocument.setCustomerId(credit.getCustomerId());
              existingCreditDocument.setCreditLimit(credit.getCreditLimit());
              existingCreditDocument.setOutstandingAmount(credit.getOutstandingAmount());
              existingCreditDocument.setInterestRate(credit.getInterestRate());
              existingCreditDocument.setTermInMonths(credit.getTermInMonths());
              existingCreditDocument.setStartDate(credit.getStartDate());

              return existingCreditDocument;
            })
        .flatMap(this.creditRepository::save)
        .then();
  }

  @Override
  public Mono<Void> activateCredit(String id) {
    return this.creditRepository
        .findById(id)
        .switchIfEmpty(Mono.error(new CreditNotFoundException()))
        .map(
            existingCreditDocument -> {
              existingCreditDocument.setIsActive(Boolean.TRUE);

              return existingCreditDocument;
            })
        .flatMap(this.creditRepository::save)
        .then();
  }

  @Override
  public Mono<Void> deactivateCredit(String id) {
    return this.creditRepository
        .findById(id)
        .switchIfEmpty(Mono.error(new CreditNotFoundException()))
        .map(
            existingCreditDocument -> {
              existingCreditDocument.setIsActive(Boolean.FALSE);

              return existingCreditDocument;
            })
        .flatMap(this.creditRepository::save)
        .then();
  }
}
