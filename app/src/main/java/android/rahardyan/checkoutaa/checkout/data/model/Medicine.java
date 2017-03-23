package android.rahardyan.checkoutaa.checkout.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by rahardyan on 23/03/17.
 */
public class Medicine implements Parcelable {
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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.name);
        dest.writeInt(this.amount);
        dest.writeLong(this.oldPrice);
        dest.writeLong(this.currentPrice);
    }

    protected Medicine(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
        this.amount = in.readInt();
        this.oldPrice = in.readLong();
        this.currentPrice = in.readLong();
    }

    public static final Parcelable.Creator<Medicine> CREATOR = new Parcelable.Creator<Medicine>() {
        @Override
        public Medicine createFromParcel(Parcel source) {
            return new Medicine(source);
        }

        @Override
        public Medicine[] newArray(int size) {
            return new Medicine[size];
        }
    };
}
