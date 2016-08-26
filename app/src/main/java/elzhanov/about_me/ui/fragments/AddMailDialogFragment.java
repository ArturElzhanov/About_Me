package elzhanov.about_me.ui.fragments;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v4.view.LayoutInflaterFactory;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.text.Layout;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import elzhanov.about_me.R;


import java.util.zip.Inflater;

/**
 * Created by User on 18.08.2016.
 */
public class AddMailDialogFragment extends AppCompatDialogFragment  {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        builder.setTitle(R.string.add_mail);
        final View v= inflater.inflate(R.layout.dialog_add_mail,null,false);
        builder.setView(v);
        builder.setPositiveButton(R.string.add, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                TextView txt_1 = (TextView) getActivity().findViewById(R.id.txt_my_mail);
                EditText editText_1 = (EditText) v.findViewById(R.id.editMailText);
                try {
                    txt_1.append(", " + editText_1.getText());
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
