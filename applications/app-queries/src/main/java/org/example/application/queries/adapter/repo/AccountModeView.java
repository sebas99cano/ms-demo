package org.example.application.queries.adapter.repo;

import org.example.domain.events.TransactionAdded;
import org.example.domain.value.WalletId;

import java.util.*;

public class AccountModeView {
    private String id;
    private String name;
    private String userId;
    private Map<String, TransactionModelView> transactionModelViews;
    private WalletModelView walletModelView;

    public WalletModelView getWalletModelView() {
        return walletModelView;
    }

    public void setWalletModelViewById(String walletId) {
        this.walletModelView = new WalletModelView(walletId);
    }

    public void setWalletModelView(WalletModelView walletModelView) {
        this.walletModelView = walletModelView;
    }

    public void setTransactionModelViews(Map<String, TransactionModelView> transactionModelViews) {
        this.transactionModelViews = transactionModelViews;
    }

    public Map<String, TransactionModelView> getTransactionModelViews() {
        if(Objects.isNull(transactionModelViews)){
            return new HashMap<>();
        }
        return transactionModelViews;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "AccountModeView{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", userId='" + userId + '\'' +
                ", transactionModelViews=" + transactionModelViews +
                '}';
    }
}
