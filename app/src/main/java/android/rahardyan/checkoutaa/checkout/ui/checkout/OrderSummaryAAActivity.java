package android.rahardyan.checkoutaa.checkout.ui.checkout;

import android.os.Bundle;
import android.rahardyan.checkoutaa.R;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class OrderSummaryAAActivity extends AppCompatActivity {
    private RecyclerView checkoutList;
    private CheckoutAdapter checkoutAdapter;

    //order line change
    private boolean placedStep = false;
    private boolean pickedUpStep = false;
    private boolean deliveredStep = false;
    private View lineOrder1;
    private View lineOrder2;
    private ImageView circlePlace;
    private ImageView circlePickedUp;
    private ImageView circleDelivered;
    //////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_summary);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        //order line change
        lineOrder1 = (View) findViewById(R.id.line_order_1);
        lineOrder2 = (View) findViewById(R.id.line_order_2);
        circlePlace = (ImageView) findViewById(R.id.circle_place);
        circlePickedUp = (ImageView) findViewById(R.id.circle_pickedup);
        circleDelivered = (ImageView) findViewById(R.id.circle_delivered);
        changeLineOrder();
        /////////
    }

    public void changeLineOrder(){
        if(placedStep==true){
            //image
            circlePlace.setImageDrawable(getResources().getDrawable(R.drawable.ic_done));
            circlePickedUp.setImageDrawable(getResources().getDrawable(R.drawable.ic_more_horiz));
            //color circle
            circlePlace.setBackground(getResources().getDrawable(R.drawable.circle_red));
            circlePickedUp.setBackground(getResources().getDrawable(R.drawable.circle_pink));
            circleDelivered.setBackground(getResources().getDrawable(R.drawable.circle_white));
            //line
            lineOrder1.setVisibility(View.VISIBLE);
            lineOrder2.setVisibility(View.GONE);
        }
        if(pickedUpStep==true){
            //image
            circlePlace.setImageDrawable(getResources().getDrawable(R.drawable.ic_done));
            circlePickedUp.setImageDrawable(getResources().getDrawable(R.drawable.ic_done));
            circleDelivered.setImageDrawable(getResources().getDrawable(R.drawable.ic_more_horiz));
            //color circle
            circlePlace.setBackground(getResources().getDrawable(R.drawable.circle_red));
            circlePickedUp.setBackground(getResources().getDrawable(R.drawable.circle_red));
            circleDelivered.setBackground(getResources().getDrawable(R.drawable.circle_pink));
            //line
            lineOrder1.setVisibility(View.VISIBLE);
            lineOrder2.setVisibility(View.VISIBLE);
        }

        if(deliveredStep==true){
            //image
            circlePlace.setImageDrawable(getResources().getDrawable(R.drawable.ic_done));
            circlePickedUp.setImageDrawable(getResources().getDrawable(R.drawable.ic_done));
            circleDelivered.setImageDrawable(getResources().getDrawable(R.drawable.ic_done));
            //color circle
            circlePlace.setBackground(getResources().getDrawable(R.drawable.circle_red));
            circlePickedUp.setBackground(getResources().getDrawable(R.drawable.circle_red));
            circleDelivered.setBackground(getResources().getDrawable(R.drawable.circle_red));
            //line
            lineOrder1.setVisibility(View.VISIBLE);
            lineOrder2.setVisibility(View.VISIBLE);
        }

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
