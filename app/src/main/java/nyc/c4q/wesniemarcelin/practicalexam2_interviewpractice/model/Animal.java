package nyc.c4q.wesniemarcelin.practicalexam2_interviewpractice.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by wesniemarcelin on 12/21/16.
 */

public class Animal {
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("textColor")
    @Expose
    public String textColor;
    @SerializedName("background")
    @Expose
    public String background;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTextColor() {
        return textColor;
    }

    public void setTextColor(String textColor) {
        this.textColor = textColor;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }
}
