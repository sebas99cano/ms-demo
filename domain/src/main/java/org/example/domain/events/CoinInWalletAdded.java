package org.example.domain.events;

import org.example.domain.value.Coin;
import org.example.domain.value.WalletId;
import org.example.generic.domain.DomainEvent;

public class CoinInWalletAdded extends DomainEvent {

    private final WalletId walletId;

    private final Coin coin;

    public CoinInWalletAdded(WalletId walletId, Coin coin) {
        super("org.example.CoinInWalletAdded");
        this.walletId = walletId;
        this.coin = coin;
    }

    public WalletId getWalletId() {
        return walletId;
    }

    public Coin getCoin() {
        return coin;
    }
}
