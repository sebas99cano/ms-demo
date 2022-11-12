package org.example.domain;

import org.example.domain.value.Coin;
import org.example.domain.value.WalletId;
import org.example.generic.domain.Entity;

public class Wallet extends Entity<WalletId> {
    private Coin coin;

    public Wallet(WalletId id, Coin coin) {
        super(id);
        this.coin = coin;
    }

    public void addCoin(Coin coin) {
        this.coin = this.coin.addCoin(coin.value());
    }
}
