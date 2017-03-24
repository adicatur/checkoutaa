package android.rahardyan.checkoutaa.checkout.ui.checkout;

import android.rahardyan.checkoutaa.R;
import android.rahardyan.checkoutaa.checkout.data.model.Medicine;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by rahardyan on 24/03/17.
 */

public class CheckoutAdapter extends RecyclerView.Adapter<CheckoutAdapter.MedicineViewHolder> {
    private List<Medicine> medicines;
    private OnItemClickListener onItemClickListener;
    private RecyclerView recyclerView;

    public CheckoutAdapter(List<Medicine> medicines, RecyclerView recyclerView, OnItemClickListener onItemClickListener) {
        this.medicines = medicines;
        this.onItemClickListener = onItemClickListener;
        this.recyclerView = recyclerView;
    }

    public CheckoutAdapter(List<Medicine> medicines) {
        this.medicines = medicines;
    }

    @Override
    public MedicineViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_checkout, parent, false);
        return new CheckoutAdapter.MedicineViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MedicineViewHolder holder, int position) {
        holder.tvMedicineName.setText(medicines.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return medicines.size();
    }

    public class MedicineViewHolder extends RecyclerView.ViewHolder {
        TextView tvMedicineName;
        public MedicineViewHolder(View view) {
            super(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int itemPositoin = recyclerView.getChildLayoutPosition(view);
                    onItemClickListener.onClick(medicines.get(itemPositoin));
                }
            });
            tvMedicineName = (TextView) view.findViewById(R.id.drugs_name);
        }
    }

    interface OnItemClickListener {
        void onClick(Medicine medicine);
    }
}
