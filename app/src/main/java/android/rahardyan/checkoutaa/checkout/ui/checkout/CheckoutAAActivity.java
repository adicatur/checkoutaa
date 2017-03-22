package android.rahardyan.checkoutaa.checkout.ui.checkout;

import android.app.ActionBar;
import android.rahardyan.checkoutaa.R;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CheckoutAAActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout_aa);

        ActionBar actionBar = getActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setTitle("Checkout");
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
}
