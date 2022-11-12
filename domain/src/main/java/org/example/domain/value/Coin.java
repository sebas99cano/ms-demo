package org.example.domain.value;

import org.example.generic.domain.ValueObject;

public class Coin implements ValueObject<Integer> {
    private final Integer value;

    public Coin(Integer value) {
        this.value = value;
        if (this.value < 0) {
            throw new IllegalArgumentException("No puedes tener monedas negativas");
        }
        if (this.value > 1000000) {
            throw new IllegalArgumentException("No puedes tener mas de 1 millon de mondeas");
        }
    }

    public Coin addCoin(Integer coin) {
        return new Coin(this.value + coin);
    }

    @Override
    public Integer value() {
        return this.value;
    }
}
