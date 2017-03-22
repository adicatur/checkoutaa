package android.rahardyan.checkoutaa.checkout.ui.checkout;

import android.content.Context;
import android.rahardyan.checkoutaa.R;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by rahardyan on 22/03/17.
 */

public class CheckoutAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<String> listCheckouts;
    private final String headerTitle = "Items";

    public CheckoutAdapter(Context context, List<String> listCheckouts) {
        this.context = context;
        this.listCheckouts = listCheckouts;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View view, ViewGroup viewGroup) {
        if (view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.item_checkout_group, viewGroup, false);
        }

        TextView tvHeaderListCheckout = (TextView) view.findViewById(R.id.tv_header_list_checkout);
        TextView tvHeaderListCheckoutCount = (TextView) view.findViewById(R.id.tv_header_list_checkout_count);
        tvHeaderListCheckout.setText(headerTitle + " ");
        Log.d("amsibsam", "list size "+listCheckouts.size());
        tvHeaderListCheckoutCount.setText("("+String.valueOf(listCheckouts.size())+")");

        return view;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View view, ViewGroup viewGroup) {
        String itemText = listCheckouts.get(childPosition);

        if (view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.item_checkout, viewGroup, false);
        }

        TextView tvItemCheckout = (TextView) view.findViewById(R.id.tv_item_checkout);
        tvItemCheckout.setText(itemText);

        return view;
    }

    @Override
    public int getGroupCount() {
        return 1;
    }

    @Override
    public int getChildrenCount(int i) {
        return listCheckouts.size();
    }

    @Override
    public Object getGroup(int i) {
        return null;
    }

    @Override
    public Object getChild(int i, int i1) {
        return null;
    }

    @Override
    public long getGroupId(int i) {
        return 0;
    }

    @Override
    public long getChildId(int i, int i1) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
}
