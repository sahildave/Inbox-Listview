package in.sahildave.material_list;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import in.sahildave.material_list.dummy.DummyContent;
import in.sahildave.material_list.dummy.DummyContent.*;

/**
 * Created by sahil on 10/4/15.
 */
public class MaterialListAdapter extends ArrayAdapter<DummyContent.DummyItem> {

    private final Context context;
    private final List<DummyItem> items;

    public MaterialListAdapter(Context context, int resource, List<DummyItem> objects) {
        super(context, resource, objects);
        this.items = objects;
        this.context = context;
    }

    @Override
    public DummyItem getItem(int position) {
        return this.items.get(position);
    }

    private static class ViewHolder {
        TextView itemName;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        DummyItem item = getItem(position);
        ViewHolder viewHolder;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.list_item, parent, false);
            viewHolder.itemName = (TextView) convertView.findViewById(R.id.itemName);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        ViewGroup.LayoutParams params = convertView.getLayoutParams();
        params.height = parent.getHeight()/3;
        convertView.setLayoutParams(params);

        // Populate the data into the template view using the data object
        viewHolder.itemName.setText(item.content);

        if (DummyContent.isAnyItemSelected) {
            if(item.selected) {
                viewHolder.itemName.setText(item.content + " is selected");
                AnimationsUtil.scaleUpAnimation(convertView);
                item.scaleLevel = 1;
            } else {
                viewHolder.itemName.setText(item.content + " is not selected");
                AnimationsUtil.scaleDownAnimation(convertView);
                item.scaleLevel = -1;
            }
        } else {
            AnimationsUtil.scaleBackAnimation(convertView);
            item.scaleLevel = 0;
        }

        Log.d("Material", "Item height is "+convertView.getHeight());
        return convertView;
    }
}
