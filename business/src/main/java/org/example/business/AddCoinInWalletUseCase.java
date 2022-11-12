package org.example.business;


import org.example.domain.Account;
import org.example.domain.command.CoinInWalletUseCommand;
import org.example.domain.value.WalletId;
import org.example.generic.business.EventStoreRepository;
import org.example.generic.domain.DomainEvent;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Function;

public class AddCoinInWalletUseCase implements Function<Mono<CoinInWalletUseCommand>, Flux<DomainEvent>> {

    private final EventStoreRepository repository;

    public AddCoinInWalletUseCase(EventStoreRepository repository) {
        this.repository = repository;
    }

    @Override
    public Flux<DomainEvent> apply(Mono<CoinInWalletUseCommand> commandMono) {
        return commandMono.flatMapMany(command -> {
            var id = command.getAccountId();
            return repository.getEventsBy("account", id.value()).collectList().flatMapIterable(events -> {
                var account = Account.from(id, events);
                account.addCoinInWallet(command.getCoin());
                return account.getUncommittedChanges();
            });
        });
    }
}
