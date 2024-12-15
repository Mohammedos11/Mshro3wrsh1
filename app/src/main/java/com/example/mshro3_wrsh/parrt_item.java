package com.example.mshro3_wrsh;

import android.graphics.drawable.Drawable;

public class parrt_item {

    private Drawable image ;
    private String Text ;

    public parrt_item(Drawable image, String text) {
        this.image = image;
        Text = text;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }
}
