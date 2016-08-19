package elzhanov.about_me;

import android.animation.Animator;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private String[] profSkills;
    private TextView prof_Skills;

    private TextView mailText;

    private ImageView infoView;
    private ImageView mailView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prof_Skills = (TextView) findViewById(R.id.prof_skills);
        Resources res = getResources();
        profSkills = res.getStringArray(R.array.prof_skills);

        infoView = (ImageView) findViewById(R.id.image_info);
        mailView = (ImageView) findViewById(R.id.image_mail);


        try {
            infoView.setOnClickListener(viewClickListenerInfo);
            mailView.setOnClickListener(viewClickListenerMail);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private View.OnClickListener viewClickListenerInfo = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            initPopup(v,R.menu.info_popup);
        }
    };

    private View.OnClickListener viewClickListenerMail = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            initPopup(v,R.menu.mail_popup);
        }
    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    // TODO: 19.08.2016 На этой неделе было мало времени, не успел раскрыть share_profile и settings
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.share_profile:

                break;

            case R.id.show_time:
                startActivity(new Intent(getApplicationContext(), ShowCurrentTimeAndDataActivity.class));
                break;

            case R.id.settings:

                break;

        }
        return super.onOptionsItemSelected(item);
    }

    public void onBtnShowText(View view) {
        prof_Skills.setMovementMethod(new ScrollingMovementMethod());
        prof_Skills.setText(null);
        for (String s : profSkills) {
            prof_Skills.append(s+"\n");
        }
    }

    public void initPopup(View view, int id) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.inflate(id);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(final MenuItem item) {
                switch (item.getItemId()){
                    case R.id.show_more:
                        startActivity(new Intent(getApplicationContext(), SecondActivity.class));
                        break;
                    case R.id.edit_account:
                        DialogFragment accountDialog = new EditAccountFragment();
                        accountDialog.show(getSupportFragmentManager(),"EDIT_ACCOUNT");
                        break;
                    case R.id.send_message:
                        Toast.makeText(getApplicationContext(), "send message", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.add_mail:
                        DialogFragment mailDialog = new AddMailDialogFragment();
                        mailDialog.show(getSupportFragmentManager(), "ADD_MAIL");
                        break;
                }

                return false;
            }
        });
        popupMenu.setOnDismissListener(new PopupMenu.OnDismissListener() {
            @Override
            public void onDismiss(final PopupMenu menu) {

            }
        });
        popupMenu.show();
    }


}
