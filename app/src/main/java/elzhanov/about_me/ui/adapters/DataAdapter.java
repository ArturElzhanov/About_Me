package elzhanov.about_me.ui.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import elzhanov.about_me.model.DataType;
import elzhanov.about_me.R;
import java.util.List;

/**
 * Created by User on 31.08.2016.
 */
public class DataAdapter extends BaseAdapter {
    private List<DataType> profile;

    public DataAdapter(List<DataType> profile) {
        this.profile = profile;
    }

    @Override
    public int getCount() {
        return profile.size();
    }

    @Override
    public Object getItem(int position) {
        return profile.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View rootView = convertView;
        if (rootView == null) rootView = View.inflate(parent.getContext(),R.layout.list_item, null);

        TextView name = (TextView) rootView.findViewById(R.id.data_name);
        name.setText(profile.get(position).getName());

        TextView value = (TextView) rootView.findViewById(R.id.data_value);
        value.setText(profile.get(position).getValue());

        ImageView picture = (ImageView) rootView.findViewById(R.id.picture);
        picture.setImageResource(profile.get(position).getPicture());

        return rootView;
    }
}
