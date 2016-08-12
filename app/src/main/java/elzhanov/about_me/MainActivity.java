package elzhanov.about_me;

import android.animation.Animator;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private String[] profSkills;
    private TextView prof_Skills;
    private TextView my_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prof_Skills = (TextView) findViewById(R.id.prof_skills);
        Resources res = getResources();
        profSkills = res.getStringArray(R.array.prof_skills);
    }

    public void onBtnShowText(View view) {
        prof_Skills.setMovementMethod(new ScrollingMovementMethod());
        prof_Skills.setText(null);
        for (String s : profSkills) {
            prof_Skills.append(s+"\n");
        }
    }
}
