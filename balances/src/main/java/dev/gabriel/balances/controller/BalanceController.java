package dev.gabriel.balances.controller;

import dev.gabriel.balances.model.Balance;
import dev.gabriel.balances.repository.BalanceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BalanceController {

    private final BalanceRepository balanceRepository;

    @GetMapping("/{accountId}")
    public ResponseEntity<Balance> getBalance(@PathVariable String accountId) {
        var optionalBalance = balanceRepository.findById(accountId);
        return ResponseEntity.of(optionalBalance);
    }
}
