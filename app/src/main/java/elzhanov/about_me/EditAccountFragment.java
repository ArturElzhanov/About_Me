package elzhanov.about_me;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by User on 19.08.2016.
 */
public class EditAccountFragment extends AppCompatDialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        builder.setTitle(R.string.edit_profile)
                .setView(inflater.inflate(R.layout.dialog_edit_account,null,false))
                .setPositiveButton(R.string.add, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EditText editText_1 = (EditText) getActivity().findViewById(R.id.editText);
                        EditText editText_2 = (EditText) getActivity().findViewById(R.id.editText2);
                        EditText editText_3 = (EditText) getActivity().findViewById(R.id.editText3);
                        TextView txt_1 = (TextView) getActivity().findViewById(R.id.txt_my_name);
                        TextView txt_2 = (TextView) getActivity().findViewById(R.id.txt_my_sir_name);
                        TextView txt_3 = (TextView) getActivity().findViewById(R.id.txt_my_last_name);
                        try {
                            txt_1.setText(editText_1.getText());
                            txt_2.setText(editText_2.getText());
                            txt_3.setText(editText_3.getText());
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
