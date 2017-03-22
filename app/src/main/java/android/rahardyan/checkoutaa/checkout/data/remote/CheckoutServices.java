package android.rahardyan.checkoutaa.checkout.data.remote;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by rahardyan on 22/03/17.
 */

public class CheckoutServices {
    public static CheckoutServices INSTANCE;
    private CheckoutAPI checkoutApi;
    private Gson gson;

    private CheckoutServices() {
        gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();

        Retrofit retrofit = new Retrofit.Builder().baseUrl("base url")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        checkoutApi = retrofit.create(CheckoutAPI.class);
    }

    public static CheckoutServices getInstance() {
        if (INSTANCE == null) {
            return new CheckoutServices();
        } else {
            return INSTANCE;
        }
    }
}
