package elzhanov.about_me.ui.fragments;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.widget.TextView;
import elzhanov.about_me.R;

/**
 * Created by User on 24.08.2016.
 */
    public class ChooseStringColorDialogFragment extends AppCompatDialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final TextView nametxt = (TextView)getActivity().findViewById(R.id.txt_my_name);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        builder.setTitle(R.string.choose_color);
        builder.setItems(R.array.text_color, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0:
                        nametxt.setTextColor(Color.BLACK);
                        break;
                    case 1:
                        nametxt.setTextColor(Color.RED);
                        break;
                    case 2:
                        nametxt.setTextColor(Color.WHITE);
                        break;
                    default:nametxt.setTextColor(Color.BLACK);
                }
            }
        });
        return builder.create();
    }
}
