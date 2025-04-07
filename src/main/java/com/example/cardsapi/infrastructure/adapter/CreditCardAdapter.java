package com.example.cardsapi.infrastructure.adapter;

import com.example.cardsapi.domain.exception.CreditCardNotFoundException;
import com.example.cardsapi.domain.model.CreditCard;
import com.example.cardsapi.domain.port.out.CreditCardRepositoryPort;
import com.example.cardsapi.infrastructure.repository.CreditCardRepository;
import com.example.cardsapi.infrastructure.repository.document.CreditCardDocument;
import com.example.cardsapi.infrastructure.repository.mapper.CreditCardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class CreditCardAdapter implements CreditCardRepositoryPort {
  private final CreditCardRepository creditCardRepository;
  private final CreditCardMapper creditCardMapper;

  @Override
  public Flux<CreditCard> findAllCreditCards() {
    return this.creditCardRepository.findAll().map(this.creditCardMapper::toCreditCard);
  }

  @Override
  public Mono<CreditCard> findCreditCardById(String id) {
    return this.creditCardRepository.findById(id).map(this.creditCardMapper::toCreditCard);
  }

  @Override
  public Mono<Void> saveCreditCard(CreditCard creditCard) {
    CreditCardDocument creditCardDocument = this.creditCardMapper.toCreditCardDocument(creditCard);
    creditCardDocument.setIsActivate(Boolean.TRUE);
    return this.creditCardRepository.save(creditCardDocument).then();
  }

  @Override
  public Mono<Void> updateCreditCard(String id, CreditCard creditCard) {
    return this.creditCardRepository
        .findById(id)
        .switchIfEmpty(Mono.error(new CreditCardNotFoundException()))
        .flatMap(
            existingCreditCardDocument -> {
              existingCreditCardDocument.setCustomerId(creditCard.getCustomerId());
              existingCreditCardDocument.setCustomerType(creditCard.getCustomerType().name());
              existingCreditCardDocument.setCardNumber(creditCard.getCardNumber());
              existingCreditCardDocument.setCreditLimit(creditCard.getCreditLimit());
              existingCreditCardDocument.setCurrentBalance(creditCard.getCurrentBalance());
              existingCreditCardDocument.setInterestRate(creditCard.getInterestRate());
              existingCreditCardDocument.setExpirationDate(creditCard.getExpirationDate());
              return this.creditCardRepository.save(existingCreditCardDocument).then();
            });
  }

  @Override
  public Mono<Void> activateCreditCard(String id) {
    return this.creditCardRepository
        .findById(id)
        .switchIfEmpty(Mono.error(new CreditCardNotFoundException()))
        .flatMap(
            creditCardDocument -> {
              creditCardDocument.setIsActivate(Boolean.TRUE);
              return this.creditCardRepository.save(creditCardDocument).then();
            });
  }

  @Override
  public Mono<Void> deactivateCreditCard(String id) {
    return this.creditCardRepository
        .findById(id)
        .switchIfEmpty(Mono.error(new CreditCardNotFoundException()))
        .flatMap(
            creditCardDocument -> {
              creditCardDocument.setIsActivate(Boolean.FALSE);
              return this.creditCardRepository.save(creditCardDocument).then();
            });
  }
}
