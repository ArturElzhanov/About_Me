package elzhanov.about_me.model;

/**
 * Created by User on 28.08.2016.
 */
public class DataType {
    private int picture;
    private String name;
    private String value;

    public DataType(int picture, String name, String value) {
        this.picture = picture;
        this.name = name;
        this.value = value;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
