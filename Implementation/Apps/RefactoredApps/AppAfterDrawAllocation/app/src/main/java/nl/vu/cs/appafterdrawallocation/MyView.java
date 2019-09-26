package nl.vu.cs.appafterdrawallocation;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

public class MyView extends View
{
    Paint paint = null;
    public MyView(Context context)
    {
        super(context);

    }
    Paint p = new Paint();

    @Override
    protected void onDraw(Canvas canvas)
    {
        Log.d("Draw method","called");
        super.onDraw(canvas);
        int x = getWidth();
        int y = getHeight();
        int radius;
        radius = 100;
        //Paint p = new Paint();
    }
}
