package android.rahardyan.checkoutaa.checkout.data.model;

/**
 * Created by rahardyan on 23/03/17.
 */
public class Medicine {
    private int id;
    private String name;
    private int amount;
    private long oldPrice;
    private long currentPrice;

    public Medicine() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setOldPrice(long oldPrice) {
        this.oldPrice = oldPrice;
    }

    public void setCurrentPrice(long currentPrice) {
        this.currentPrice = currentPrice;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public long getOldPrice() {
        return oldPrice;
    }

    public long getCurrentPrice() {
        return currentPrice;
    }
}
