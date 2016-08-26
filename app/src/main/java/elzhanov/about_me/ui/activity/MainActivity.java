package elzhanov.about_me.ui.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import elzhanov.about_me.*;
import elzhanov.about_me.ui.fragments.AddMailDialogFragment;
import elzhanov.about_me.ui.fragments.ChooseBackColorDialogFragment;
import elzhanov.about_me.ui.fragments.ChooseStringColorDialogFragment;
import elzhanov.about_me.ui.fragments.EditAccountFragment;


public class MainActivity extends AppCompatActivity {


    private Spinner spSpin = null;
    private ImageView infoView;
    private ImageView mailView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initSpinner();

        initImagePush();
    }

    private void initImagePush() {
        infoView = (ImageView) findViewById(R.id.image_info);
        mailView = (ImageView) findViewById(R.id.image_mail);
        try {
            infoView.setOnClickListener(viewClickListenerInfo);
            mailView.setOnClickListener(viewClickListenerMail);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
// проф. навыки решил сделать выпадающим списком
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.share_profile:
                // TODO: 26.08.2016 Хочу отправлять профиль по сети, но мы пока работу с сетью не проходили
                break;
            case R.id.show_time:
                startActivity(new Intent(getApplicationContext(), ShowCurrentTimeAndDataActivity.class));
                break;
            case R.id.set_back:
                //создаю диалог выбора цвета фона
                DialogFragment backColor = new ChooseBackColorDialogFragment();
                backColor.show(getSupportFragmentManager(),"BACK_COLOR");
                break;
            case R.id.set_text_color:
                //создаю диалог выбора цвета текста
                DialogFragment textColor = new ChooseStringColorDialogFragment();
                textColor.show(getSupportFragmentManager(),"TEXT_COLOR");
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onBtnShowText(View view) {
        // TODO: 26.08.2016 не реализованное пока добавление навыков, от нажатия кнопки
    }
//метод для создания плавающих окон
    public void initPopup(View view, int id) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.inflate(id);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(final MenuItem item) {
                switch (item.getItemId()){
                    //показываю расширенную информацию о себе
                    case R.id.show_more:
                        startActivity(new Intent(getApplicationContext(), SecondActivity.class));
                        break;
                    //замена данных в аккаунте
                    case R.id.edit_account:
                        DialogFragment accountDialog = new EditAccountFragment();
                        accountDialog.show(getSupportFragmentManager(),"EDIT_ACCOUNT");
                        break;
                    case R.id.send_message:
                        Toast.makeText(getApplicationContext(), "send message", Toast.LENGTH_SHORT).show();
                        break;
                    //добавляю адреса
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
