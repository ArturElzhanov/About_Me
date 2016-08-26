package elzhanov.about_me.ui.fragments;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.widget.DatePicker;
import android.widget.TextView;
import elzhanov.about_me.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by User on 19.08.2016.
 */
public class DataPickFragment extends AppCompatDialogFragment implements DatePickerDialog.OnDateSetListener {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    @Override
    public void onDateSet(final DatePicker datePicker, final int i, final int i1, final int i2) {
        TextView txt_1 = (TextView) getActivity().findViewById(R.id.txt_data);
        GregorianCalendar calendar = new GregorianCalendar(i, i1, i2);
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE MM yyyy");
        txt_1.setText(dateFormat.format(calendar.getTime()));

    }
}
