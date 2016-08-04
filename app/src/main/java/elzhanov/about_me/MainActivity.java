package elzhanov.about_me;

import android.animation.Animator;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private String[] profSkills;

    private TextView my_text;
    private Animation showtext,disappeartext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView)findViewById(R.id.listView);
        Resources res = getResources();
        profSkills = res.getStringArray(R.array.prof_skills);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_item, profSkills);
        listView.setAdapter(adapter);

        my_text = (TextView)findViewById(R.id.text_orient);
        showtext = AnimationUtils.loadAnimation(this,R.anim.showtext);
        disappeartext = AnimationUtils.loadAnimation(this,R.anim.disappeartext);
        my_text.startAnimation(showtext);
        showtext.setAnimationListener(animationShowTextListener);
    }
    private Animation.AnimationListener animationShowTextListener = new Animation.AnimationListener() {
        @Override
        public void onAnimationStart(Animation animation) {
            String s= getString(R.string.my_text);
            my_text.setText(s);
        }

        @Override
        public void onAnimationEnd(Animation animation) {
            my_text.startAnimation(disappeartext);
            disappeartext.setAnimationListener(animationDisappTextListener);
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    };
    private Animation.AnimationListener animationDisappTextListener = new Animation.AnimationListener() {
        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            my_text.setText(null);
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    };
}
