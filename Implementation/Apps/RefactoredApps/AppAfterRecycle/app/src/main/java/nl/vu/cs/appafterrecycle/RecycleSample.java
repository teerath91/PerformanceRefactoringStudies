package nl.vu.cs.appafterrecycle;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;


public class RecycleSample extends View {

    public RecycleSample(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void example(AttributeSet attrs, int defStyle) {
        final TypedArray a = getContext().obtainStyledAttributes(attrs, new int[]{0}, defStyle, 0);
        String s = a.getString(0);
        if (a != null) {
            a.recycle();
        }
    }
}
