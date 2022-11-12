package org.example.application.queries.adapter.repo;

public class WalletModelView {
    private String walletId;
    private Integer coin;

    public String getWalletId() {
        return walletId;
    }

    public WalletModelView(String walletId) {
        this.walletId = walletId;
        this.coin = 0;
    }

    public WalletModelView() {
    }

    public void setWalletId(String walletId) {
        this.walletId = walletId;
    }

    public Integer getCoin() {
        return coin;
    }

    public void setCoin(Integer coin) {
        this.coin = coin;
    }

    @Override
    public String toString() {
        return "WalletModelView{" +
                "walletId='" + walletId + '\'' +
                ", coin=" + coin +
                '}';
    }
}
