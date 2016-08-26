package elzhanov.about_me.ui.fragments;

import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import elzhanov.about_me.ui.adapters.CustomAdapter;
import elzhanov.about_me.R;
import elzhanov.about_me.model.ChooseBackGround;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 24.08.2016.
 */
public class ChooseBackColorDialogFragment extends AppCompatDialogFragment {
    ListView lv;
    List<ChooseBackGround> backGrounds = new ArrayList<>();
    CustomAdapter listAdapter;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final RelativeLayout layout = (RelativeLayout)getActivity().findViewById(R.id.MainRelative);
        listAdapter = new CustomAdapter(loadData());
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        final View v= inflater.inflate(R.layout.dialog_choose_back,null,false);
        lv = (ListView) v.findViewById(R.id.listView);
        lv.setAdapter(listAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                for (int i = 0; i < backGrounds.size() ; i++) {
                    if(position==i) layout.setBackgroundColor(getResources().getColor(backGrounds.get(position).getColor()));
                }
            }
        });
        builder.setView(v);
        return builder.create();
    }

    private List<ChooseBackGround> loadData() {
        backGrounds.add(new ChooseBackGround(R.color.lightBlue,"BLUE"));
        backGrounds.add(new ChooseBackGround(R.color.lightYellow,"YELLOW"));
        backGrounds.add(new ChooseBackGround(R.color.lightGrey,"GREY"));
        backGrounds.add(new ChooseBackGround(R.color.lightCyan,"CYAN"));
        backGrounds.add(new ChooseBackGround(R.color.lightOrange,"ORANGE"));
        return backGrounds;
    }


}
