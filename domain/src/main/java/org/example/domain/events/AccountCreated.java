package org.example.domain.events;

import org.example.domain.Wallet;
import org.example.domain.value.Name;
import org.example.domain.value.UserId;
import org.example.domain.value.WalletId;
import org.example.generic.domain.DomainEvent;

public class AccountCreated extends DomainEvent {
    private final UserId userId;
    private final Name name;

    private final WalletId walletId;

    public AccountCreated(UserId userId, Name name, WalletId walletId) {
        super("org.example.AccountCreated");
        this.userId = userId;
        this.name = name;
        this.walletId = walletId;
    }

    public Name getName() {
        return name;
    }

    public UserId getUserId() {
        return userId;
    }

    public WalletId getWalletId() {
        return walletId;
    }
}
