package elzhanov.about_me.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import elzhanov.about_me.R;
import elzhanov.about_me.model.DataType;
import elzhanov.about_me.ui.adapters.DataAdapter;
import elzhanov.about_me.ui.fragments.EditAccountFragment;

import java.util.ArrayList;
import java.util.List;


public class SecondActivity extends AppCompatActivity {

    private ListView lv;
    private DataAdapter adapter;
    private List<DataType> profile = new ArrayList<>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        lv = (ListView) findViewById(R.id.lv);
        adapter = new DataAdapter(createData());
        lv.setAdapter(adapter);
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, profile.get(position).getValue());
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
                return false;
            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }
    private List<DataType> createData() {

        profile.add(new DataType(getIntent().getIntExtra("photo",android.R.drawable.ic_delete),
                "Full name", getIntent().getStringExtra("full name")));
        profile.add(new DataType(getIntent().getIntExtra("ic_mail",android.R.drawable.ic_delete),
                "Mail",getIntent().getStringExtra("my_mail")));
        profile.add(new DataType(android.R.drawable.ic_menu_call,getString(R.string.phone_num),getString(R.string._8987_80)));
        profile.add(new DataType(android.R.drawable.ic_menu_my_calendar,getString(R.string.date_of_birth),getString(R.string._23_12_1984)));
        profile.add(new DataType(android.R.drawable.ic_dialog_info,getString(R.string.education),getString(R.string.kazan_technological_univercity)));
        profile.add(new DataType(android.R.drawable.ic_menu_compass,getString(R.string.hobby),getString(R.string.martial_arts)));

        return profile;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.edit_account,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.edit_account:
                DialogFragment accountDialog = new EditAccountFragment();
                accountDialog.show(getSupportFragmentManager(),"EDIT_ACCOUNT");
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
