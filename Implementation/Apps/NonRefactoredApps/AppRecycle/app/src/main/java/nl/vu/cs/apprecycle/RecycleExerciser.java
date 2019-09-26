package nl.vu.cs.apprecycle;

import android.content.Context;
import android.util.AttributeSet;

public class RecycleExerciser implements Exerciser {
    Context context;
    AttributeSet attrs;
    int defStyle;

    RecycleExerciser (Context context, AttributeSet attrs, int defStyle) {
        this.context = context;
        this.attrs = attrs;
        this.defStyle = defStyle;
    }

    @Override
    public void exercise() {

        RecycleSample recycle = new RecycleSample(context, attrs, defStyle);
        recycle.example(attrs, defStyle);
    }

}
