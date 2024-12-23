package dev.gabriel.balances.listener;

import com.fasterxml.jackson.annotation.JsonProperty;

public record BalanceKafkaMessage(
        @JsonProperty("Name")
        String name,
        @JsonProperty("Payload")
        BalanceKafkaMessagePayload payload
) {
}
