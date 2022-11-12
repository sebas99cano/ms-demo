package org.example.domain.value;

import org.example.generic.domain.Identity;

public class WalletId extends Identity {
    public WalletId() {
    }

    private WalletId(String id) {
        super(id);
    }

    public static WalletId of(String id) {
        return new WalletId(id);
    }
}
