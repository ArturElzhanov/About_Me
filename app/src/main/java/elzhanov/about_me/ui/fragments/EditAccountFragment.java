package elzhanov.about_me.ui.fragments;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import elzhanov.about_me.R;

/**
 * Created by User on 19.08.2016.
 */
public class EditAccountFragment extends AppCompatDialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        builder.setTitle(R.string.edit_profile);
        final View v= inflater.inflate(R.layout.dialog_edit_account,null,false);
        builder.setView(v)
               .setPositiveButton(R.string.add, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EditText editText_1 = (EditText) v.findViewById(R.id.editText);
                        EditText editText_2 = (EditText) v.findViewById(R.id.editText2);
                        EditText editText_3 = (EditText) v.findViewById(R.id.editText3);
                        EditText editText_4 = (EditText) v.findViewById(R.id.editText4);
                        EditText editText_5 = (EditText) v.findViewById(R.id.editText5);
                        EditText editText_6 = (EditText) v.findViewById(R.id.editText6);
                        EditText editText_7 = (EditText) v.findViewById(R.id.editText7);
                        EditText editText_8 = (EditText) v.findViewById(R.id.editText8);
                        TextView txt_1 = (TextView) getActivity().findViewById(R.id.txt_my_name);
                        TextView txt_2 = (TextView) getActivity().findViewById(R.id.txt_my_sir_name);
                        TextView txt_3 = (TextView) getActivity().findViewById(R.id.txt_my_last_name);
                        TextView txt_4 = (TextView) getActivity().findViewById(R.id.txt_my_mail);
                        try {
                            txt_1.setText(editText_1.getText());
                            txt_2.setText(editText_2.getText());
                            txt_3.setText(editText_3.getText());
                            txt_4.setText(editText_4.getText());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                })

                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

        return builder.create();
    }
}
