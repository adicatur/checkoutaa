package android.rahardyan.checkoutaa.checkout.ui.checkout;

import android.rahardyan.checkoutaa.R;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.List;

public class CheckoutAAActivity extends AppCompatActivity {
    private ExpandableListView checkoutList;
    private CheckoutAdapter checkoutAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout_aa);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        checkoutList = (ExpandableListView) findViewById(R.id.checkout_listview);

        checkoutAdapter = new CheckoutAdapter(this, generateDummyData());
        checkoutList.setAdapter(checkoutAdapter);
        checkoutList.expandGroup(0);
        checkoutAdapter.notifyDataSetChanged();

    }

    private List<String> generateDummyData() {
        List<String> listCheckout = new ArrayList<>();
        listCheckout.add("item 1");
        listCheckout.add("item 2");
        listCheckout.add("item 3");

        return listCheckout;
    }

//    if need to override the actionbar back button remove this if no need
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return true;
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if(android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.JELLY_BEAN_MR2) {
            checkoutList.setIndicatorBounds(checkoutList.getRight()- 40, checkoutList.getWidth());
        } else {
            checkoutList.setIndicatorBoundsRelative(checkoutList.getRight()- 100, checkoutList.getWidth());
        }
    }
}
