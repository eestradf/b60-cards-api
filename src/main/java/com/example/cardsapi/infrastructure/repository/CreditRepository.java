package com.example.cardsapi.infrastructure.repository;

import com.example.cardsapi.infrastructure.repository.document.CreditDocument;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CreditRepository extends ReactiveMongoRepository<CreditDocument, String> {}
