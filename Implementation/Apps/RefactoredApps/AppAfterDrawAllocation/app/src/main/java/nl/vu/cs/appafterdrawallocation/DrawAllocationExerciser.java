package nl.vu.cs.appafterdrawallocation;

import android.content.Context;
import android.graphics.Canvas;
import android.util.Log;


public class DrawAllocationExerciser implements Exerciser {
    Canvas c;
    Context context;

    DrawAllocationExerciser (Context context) {
        this.context = context;
        this.c = c;
    }

    @Override
    public void exercise() {


        MyView myview = new MyView(context);
        myview.onDraw(c);

        Log.d("Draw method","exerciser method called3");
        //myview.invalidate();

        //activity.setContentView(new MyView(activity));

    }
}