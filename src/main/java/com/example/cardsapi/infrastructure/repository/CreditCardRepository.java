package com.example.cardsapi.infrastructure.repository;

import com.example.cardsapi.infrastructure.repository.document.CreditCardDocument;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CreditCardRepository extends ReactiveMongoRepository<CreditCardDocument, String> {}
