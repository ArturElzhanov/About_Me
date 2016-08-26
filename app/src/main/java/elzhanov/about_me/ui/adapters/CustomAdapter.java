package elzhanov.about_me.ui.adapters;


import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.view.LayoutInflater;
import android.widget.TextView;
import elzhanov.about_me.R;
import elzhanov.about_me.model.ChooseBackGround;

import java.util.List;


public class CustomAdapter extends BaseAdapter  {
    private List<ChooseBackGround> backGrounds;

    public CustomAdapter(List<ChooseBackGround> backGrounds) {
        this.backGrounds = backGrounds;
    }


    @Override
    public int getCount() {
        return backGrounds.size();
    }

    @Override
    public Object getItem(int position) {
        return backGrounds.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        View rootView = view;
        if(rootView==null) rootView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.background,viewGroup,false);
        TextView textView = (TextView) rootView.findViewById(R.id.textView);
        textView.setText(backGrounds.get(position).getName());
        // TODO: 26.08.2016 Хотел чтобы у каждого представления элемента в list был свой цвет фона, но выходит для всех один  
        rootView.setBackgroundColor(backGrounds.get(position).getColor());

        return rootView;
    }

}
