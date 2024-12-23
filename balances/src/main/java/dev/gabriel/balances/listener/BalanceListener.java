package dev.gabriel.balances.listener;

import dev.gabriel.balances.model.Balance;
import dev.gabriel.balances.repository.BalanceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BalanceListener {

    private final BalanceRepository balanceRepository;

    @KafkaListener(topics = "balances")
    public void listenForBalanceMessage(BalanceKafkaMessage message) {

        System.out.println("Received Message: " + message);

        Balance updateBalanceTo = new Balance(
                message.payload().accountIdTo(),
                message.payload().balanceAccountIdTo()
        );
        Balance updateBalanceFrom = new Balance(
                message.payload().accountIdFrom(),
                message.payload().balanceAccountIdFrom()
        );

        balanceRepository.saveAll(List.of(updateBalanceTo, updateBalanceFrom));

        System.out.println("balances updated");

    }
}