package com.vallarmargoulisdevstudio.random_picker;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.EditText;

public class ViewUtils {

    public static String getText(EditText editText) {
        return editText.getText().toString();
    }

    public static int getColor(View view) {
        Drawable background = view.getBackground();
        return ((ColorDrawable) background).getColor();
    }
}
