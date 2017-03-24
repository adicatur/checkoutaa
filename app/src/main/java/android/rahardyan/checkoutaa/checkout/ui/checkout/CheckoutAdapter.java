package android.rahardyan.checkoutaa.checkout.ui.checkout;

import android.rahardyan.checkoutaa.R;
import android.rahardyan.checkoutaa.checkout.data.model.Medicine;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

/**
 * Created by rahardyan on 22/03/17.
 */

public class CheckoutAdapter extends ExpandableRecyclerViewAdapter<CheckoutAdapter.GroupViewHolder, CheckoutAdapter.ChildViewHolder> {

    public CheckoutAdapter(List<? extends ExpandableGroup> groups) {
        super(groups);
    }

    @Override
    public GroupViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_checkout_group, parent, false);
        return new GroupViewHolder(view);
    }

    @Override
    public ChildViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_checkout, parent, false);
        return new ChildViewHolder(view);
    }

    @Override
    public void onBindChildViewHolder(ChildViewHolder holder, int flatPosition, ExpandableGroup group, int childIndex) {
        final Medicine medicine = (Medicine) group.getItems().get(childIndex);
        holder.setView(medicine);
    }

    @Override
    public void onBindGroupViewHolder(GroupViewHolder holder, int flatPosition, ExpandableGroup group) {
        holder.setGenreTitle(group);
    }

    public class GroupViewHolder extends com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder {

        private TextView genreTitle;
        private ImageView expandIndicator;

        public GroupViewHolder(View itemView) {
            super(itemView);
            genreTitle = (TextView) itemView.findViewById(R.id.tv_header_list_checkout);
            expandIndicator = (ImageView) itemView.findViewById(R.id.indicator);
        }

        public void setGenreTitle(ExpandableGroup group) {
            genreTitle.setText(group.getTitle());
        }

        @Override
        public void expand() {
            super.expand();
            expandIndicator.setImageResource(android.R.drawable.arrow_up_float);
        }

        @Override
        public void collapse() {
            super.collapse();
            expandIndicator.setImageResource(android.R.drawable.arrow_down_float);
        }
    }

    public class ChildViewHolder extends com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder {

        private TextView medicineName;

        public ChildViewHolder(View itemView) {
            super(itemView);
            medicineName = (TextView) itemView.findViewById(R.id.medicine_name);
        }

        public void setView(Medicine medicine) {
            medicineName.setText(medicine.getName());
        }
    }
}
