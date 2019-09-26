package nl.vu.cs.appviewholder;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ViewHolderExerciser implements Exerciser {
    int position;
    View convertView;
    ViewGroup parent;
    Activity activity;


    ViewHolderExerciser (Activity activity, ViewGroup parent) {
        this.activity = activity;
        this.parent = parent;
        this.convertView = LayoutInflater.from(activity).inflate(R.layout.your_layout, null);
    }


    @Override
    public void exercise() {

        ViewHolderSample.Adapter holder = new ViewHolderSample.Adapter(activity);
        holder.getView(position, convertView, parent);
    }
}

