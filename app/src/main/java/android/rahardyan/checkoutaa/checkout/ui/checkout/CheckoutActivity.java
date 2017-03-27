package android.rahardyan.checkoutaa.checkout.ui.checkout;

import android.content.Intent;
import android.os.Bundle;
import android.rahardyan.checkoutaa.R;
import android.rahardyan.checkoutaa.checkout.data.model.Medicine;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.vansuita.pickimage.bean.PickResult;
import com.vansuita.pickimage.bundle.PickSetup;
import com.vansuita.pickimage.dialog.PickImageDialog;
import com.vansuita.pickimage.listeners.IPickResult;

import java.util.ArrayList;
import java.util.List;

public class CheckoutActivity extends AppCompatActivity {
    private RecyclerView checkoutList;
    private CheckoutAdapter checkoutAdapter;
    private Button btnSubmit;
    private RelativeLayout uploadImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout_aa);
        targetView();
        initActionBar();
        initRecyclerView();
        initUploadPres();
    }

    private void initUploadPres() {
        uploadImage = (RelativeLayout) findViewById(R.id.checkout_prescription);
        uploadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PickImageDialog.build(new PickSetup())
                        .setOnPickResult(new IPickResult() {
                            @Override
                            public void onPickResult(PickResult r) {
                                if (r.getError() == null) {
                                    //If you want the Uri.
                                    //Mandatory to refresh image from Uri.
                                    //getImageView().setImageURI(null);

                                    //Setting the real returned image.
                                    //getImageView().setImageURI(r.getUri());

                                    //If you want the Bitmap.
//                                   getImageView().setImageBitmap(r.getBitmap());

                                    //Image path
                                    Log.d("get", "" + r.getPath());
                                } else {
                                    //Handle possible errors
                                    //TODO: do what you have to do with r.getError();
                                    r.getError();
                                }
                            }
                        }).show(getSupportFragmentManager());
            }
        });
    }

    private void targetView() {
        checkoutList = (RecyclerView) findViewById(R.id.checkout_listview);
        btnSubmit = (Button) findViewById(R.id.btn_confirm);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CheckoutActivity.this, OrderSummaryAAActivity.class));
            }
        });
    }

    private void initActionBar() {
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    private void initRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        checkoutAdapter = new CheckoutAdapter(generateDummyData());
        checkoutList.setLayoutManager(layoutManager);
        checkoutList.setAdapter(checkoutAdapter);
    }

    //    temporary use dummy data for checkout item
    private List<Medicine> generateDummyData() {
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
}
