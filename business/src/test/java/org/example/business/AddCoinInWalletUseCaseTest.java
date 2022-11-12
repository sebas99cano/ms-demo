package org.example.business;

import org.example.domain.command.AddTransactionUseCommand;
import org.example.domain.command.CoinInWalletUseCommand;
import org.example.domain.events.AccountCreated;
import org.example.domain.events.CoinInWalletAdded;
import org.example.domain.events.TransactionAdded;
import org.example.domain.value.*;
import org.example.generic.business.EventStoreRepository;
import org.example.generic.domain.DomainEvent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AddCoinInWalletUseCaseTest {

    @InjectMocks
    AddCoinInWalletUseCase useCase;

    @Mock
    EventStoreRepository repository;

    @Test
    void addCoinInWallet(){
        var id = AccountId.of("xxxx");
        var command = new CoinInWalletUseCommand(id, new Coin(0));
        when(repository.getEventsBy(any(), any())).thenReturn(storedEvent());
        StepVerifier.create(useCase.apply(Mono.just(command)))
                .expectNextMatches((domainEvent -> {
                    var event = (CoinInWalletAdded)domainEvent;
                    return event.type.equals("org.example.CoinInWalletAdded");
                }))
                .expectComplete()
                .verify();
    }

    private Flux<DomainEvent> storedEvent() {
        return Flux.just(
                new AccountCreated(new UserId(), new Name("Raul Alzate"),new WalletId()),
                new CoinInWalletAdded(new WalletId(),new Coin(5)),
                new CoinInWalletAdded(new WalletId(),new Coin(5))
        );
    }

}