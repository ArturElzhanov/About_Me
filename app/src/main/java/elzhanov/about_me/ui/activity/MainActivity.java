package elzhanov.about_me.ui.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import elzhanov.about_me.*;
import elzhanov.about_me.ui.fragments.ChooseBackColorDialogFragment;
import elzhanov.about_me.ui.fragments.EditAccountFragment;


public class MainActivity extends AppCompatActivity {


    private TextView name;
    private TextView sname;
    private TextView lname;
    private TextView mail;

    private Spinner spSpin = null;

    public MainActivity() {
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ui();

    }

    private void ui() {
        name = (TextView) findViewById(R.id.txt_my_name);
        sname = (TextView) findViewById(R.id.txt_my_sir_name);
        lname = (TextView) findViewById(R.id.txt_my_last_name) ;
        mail = (TextView) findViewById(R.id.txt_my_mail);
        try {
            name.setText(R.string.my_name);
            sname.setText(R.string.my_sir_name);
            lname.setText(R.string.my_last_name);
            mail.setText(R.string.my_e_mail);
        } catch (Exception e) {
            e.printStackTrace();
        }
        initSpinner();
    }

    private void initSpinner() {
        spSpin = (Spinner) this.findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.prof_skills,R.layout.spin_item);
        adapter.setDropDownViewResource(R.layout.spin_item_drop);
        try {
            spSpin.setAdapter(adapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.linkedin_profile:
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ru.linkedin.com/in/artur-elzhanov-8aa2a9128"));
                startActivity(browserIntent);
                break;


            case R.id.show_all_profile:
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                intent.putExtra("photo", R.drawable.photo_portrait_sm);
                intent.putExtra("full name", name.getText()+" "+sname.getText()+" "+lname.getText());
                intent.putExtra("ic_mail",android.R.drawable.ic_dialog_email);
                intent.putExtra("my_mail", mail.getText()+" ");
                startActivity(intent);
                break;

            case R.id.set_colors:
                //создаю диалог выбора цвета фона
                DialogFragment backColor = new ChooseBackColorDialogFragment();
                backColor.show(getSupportFragmentManager(),"BACK_COLOR");
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    public void onBtnShowText(View view) {
        // TODO: 26.08.2016 не реализованное пока добавление навыков, от нажатия кнопки
    }

}
