package com.example.cardsapi.application.controller;

import com.example.cardsapi.application.dto.CreditRequestDto;
import com.example.cardsapi.application.dto.CreditResponseDto;
import com.example.cardsapi.application.mapper.CreditInitMapper;
import com.example.cardsapi.domain.model.Credit;
import com.example.cardsapi.domain.port.in.CreditUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/credits")
@RequiredArgsConstructor
public class CreditController {
  private final CreditUseCase creditUseCase;
  private final CreditInitMapper creditInitMapper;

  @GetMapping
  public Flux<CreditResponseDto> getAllCredits() {
    return this.creditUseCase.findAllCredits().map(this.creditInitMapper::toCreditResponseDto);
  }

  @GetMapping("/{credit-id}")
  public Mono<CreditResponseDto> getCreditById(@PathVariable("credit-id") String id) {
    return this.creditUseCase.findCreditById(id).map(this.creditInitMapper::toCreditResponseDto);
  }

  @PostMapping
  public Mono<Void> createCredit(@RequestBody CreditRequestDto creditRequestDto) {
    Credit credit = this.creditInitMapper.toCredit(creditRequestDto);
    return this.creditUseCase.saveCredit(credit);
  }

  @PutMapping("/{credit-id}")
  public Mono<Void> updateCredit(
      @PathVariable("credit-id") String id, @RequestBody CreditRequestDto creditRequestDto) {
    Credit credit = this.creditInitMapper.toCredit(creditRequestDto);
    return this.creditUseCase.updateCredit(id, credit);
  }

  @PutMapping("/{credit-id}/activate")
  public Mono<Void> activateCreditById(@PathVariable("credit-id") String id) {
    return this.creditUseCase.activateCredit(id);
  }

  @PutMapping("/{credit-id}/deactivate")
  public Mono<Void> deactivateCreditById(@PathVariable("credit-id") String id) {
    return this.creditUseCase.deactivateCredit(id);
  }
}
