package android.rahardyan.checkoutaa.checkout.data.model;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

/**
 * Created by rahardyan on 23/03/17.
 */

public class ItemGroup extends ExpandableGroup<Medicine> {
    public ItemGroup(String title, List<Medicine> items) {
        super(title, items);
    }
}
