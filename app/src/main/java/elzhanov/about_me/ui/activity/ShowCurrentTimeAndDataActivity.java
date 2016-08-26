package elzhanov.about_me.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import elzhanov.about_me.R;
import elzhanov.about_me.ui.fragments.TimePickerFragment;
import elzhanov.about_me.ui.fragments.DataPickFragment;

/**
 * Created by User on 19.08.2016.
 */
public class ShowCurrentTimeAndDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_time);

    }

    public void showDatePickerDialog(View view) {
        DialogFragment newFragment = new DataPickFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public void showTimePickerDialog(View view) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }
}
