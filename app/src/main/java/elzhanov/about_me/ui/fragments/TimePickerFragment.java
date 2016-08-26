package elzhanov.about_me.ui.fragments;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.text.format.DateFormat;
import android.widget.TextView;
import android.widget.TimePicker;
import elzhanov.about_me.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by User on 19.08.2016.
 */
public class TimePickerFragment extends AppCompatDialogFragment implements TimePickerDialog.OnTimeSetListener {


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        return new TimePickerDialog(getActivity(), this, hour, minute,
                DateFormat.is24HourFormat(getActivity()));
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        TextView txt_1 = (TextView) getActivity().findViewById(R.id.txt_time);
        String strTime = hourOfDay+":"+minute;
        txt_1.setText(strTime);
    }
}
