package dev.gabriel.balances.listener;

import com.fasterxml.jackson.annotation.JsonProperty;

public record BalanceKafkaMessagePayload(

        @JsonProperty("account_id_from")
        String accountIdFrom,

        @JsonProperty("account_id_to")
        String accountIdTo,

        @JsonProperty("balance_account_id_from")
        double balanceAccountIdFrom,

        @JsonProperty("balance_account_id_to")
        double balanceAccountIdTo
) {
}
