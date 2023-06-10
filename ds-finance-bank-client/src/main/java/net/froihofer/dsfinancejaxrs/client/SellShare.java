package net.froihofer.dsfinancejaxrs.client;

public class SellShare {

    private int shares;
    private String symbol;

    public SellShare() {

    }

    public SellShare(int shares, String symbol) {
        this.shares = shares;
        this.symbol = symbol;
    }

    public int getShares() {
        return shares;
    }

    public void setShares(int shares) {
        this.shares = shares;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

}