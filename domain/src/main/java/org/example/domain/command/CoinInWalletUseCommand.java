package org.example.domain.command;

import org.example.domain.value.AccountId;
import org.example.domain.value.Coin;
import org.example.generic.domain.Command;

public class CoinInWalletUseCommand extends Command {

    private final AccountId accountId;

    private final Coin coin;

    public CoinInWalletUseCommand(AccountId accountId, Coin coin) {
        this.accountId = accountId;
        this.coin = coin;
    }

    public AccountId getAccountId() {
        return accountId;
    }

    public Coin getCoin() {
        return coin;
    }
}
