package net.froihofer.dsfinancejaxrs.client;

public class SellShare {

    private String amount;
    private String share;

    public SellShare() {

    }

    public SellShare(String amount, String share) {
        this.amount = amount;
        this.share = share;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getShare() {
        return share;
    }

    public void setShare(String share) {
        this.share = share;
    }

}
