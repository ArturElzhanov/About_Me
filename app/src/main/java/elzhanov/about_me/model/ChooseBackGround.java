package elzhanov.about_me.model;

import android.content.res.Resources;

/**
 * Created by User on 25.08.2016.
 */
public class ChooseBackGround {
    private int color;
    private String name;

    public ChooseBackGround(int color, String name) {
        this.color = color;
        this.name = name;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
