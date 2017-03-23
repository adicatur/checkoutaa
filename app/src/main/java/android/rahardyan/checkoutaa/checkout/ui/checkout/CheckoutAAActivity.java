package android.rahardyan.checkoutaa.checkout.ui.checkout;

import android.rahardyan.checkoutaa.R;
import android.rahardyan.checkoutaa.checkout.data.model.ItemGroup;
import android.rahardyan.checkoutaa.checkout.data.model.Medicine;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.List;

public class CheckoutAAActivity extends AppCompatActivity {
    private RecyclerView checkoutList;
    private CheckoutAdapter checkoutAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout_aa);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        checkoutList = (RecyclerView) findViewById(R.id.checkout_listview);

        checkoutAdapter = new CheckoutAdapter(generateDummyData());
        checkoutList.setLayoutManager(layoutManager);
        checkoutList.setAdapter(checkoutAdapter);

    }

    private List<ItemGroup> generateDummyData() {
        List<ItemGroup> listCheckoutGroup = new ArrayList<>();
        List<Medicine> listCheckout = new ArrayList<>();


        Medicine medicine1 = new Medicine();
        medicine1.setName("paramex");
        Medicine medicine2 = new Medicine();
        medicine2.setName("panadol");
        Medicine medicine3 = new Medicine();
        medicine3.setName("bodrex");

        listCheckout.add(medicine1);
        listCheckout.add(medicine2);
        listCheckout.add(medicine3);


        listCheckoutGroup.add(new ItemGroup("Item", listCheckout));


        return listCheckoutGroup;
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
}
