package org.example.domain;

import org.example.domain.events.AccountCreated;
import org.example.domain.events.CoinInWalletAdded;
import org.example.domain.events.TransactionAdded;
import org.example.domain.value.*;
import org.example.generic.domain.AggregateRoot;
import org.example.generic.domain.DomainEvent;

import java.util.*;

public class Account extends AggregateRoot<AccountId> {

    protected Name name;
    protected UserId userId;
    protected Wallet wallet;
    protected Map<TransactionId, Transaction> transactions;

    public Account(AccountId id, UserId userId, Name name) {
        super(id);
        subscribe(new AccountEventChange(this));
        appendChange(new AccountCreated(userId, name, new WalletId())).apply();
    }

    private Account(AccountId id) {
        super(id);
        subscribe(new AccountEventChange(this));
    }

    public static Account from(AccountId id, List<DomainEvent> events) {
        var account = new Account(id);
        events.forEach(account::applyEvent);
        return account;
    }

    public void addTransaction(TransactionId id, Date date) {
        appendChange(new TransactionAdded(id, date)).apply();
    }

    public void addCoinInWallet(Coin coin) {
        appendChange(new CoinInWalletAdded(wallet.entityId(),coin)).apply();
    }

    public Transaction getTransactionById(TransactionId id) {
        return transactions.get(id);
    }

    public Collection<Transaction> transactions() {
        return transactions.values();
    }

    public Name name() {
        return name;
    }

    public UserId userId() {
        return userId;
    }
}
