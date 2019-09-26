package nl.vu.cs.appafterviewholder;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ViewHolderExerciser implements Exerciser {

    int position;
    View convertView;
    ViewGroup parent;
    Activity activity;


    ViewHolderExerciser (Activity activity, ViewGroup parent) {
        this.activity = activity;
        this.parent = parent;
        this.convertView = LayoutInflater.from(activity).inflate(R.layout.your_layout, null);

        ViewHolderSample.Adapter.ViewHolderItem viewHolderItem = new ViewHolderSample.Adapter.ViewHolderItem();
        viewHolderItem.text = (TextView) convertView.findViewById(R.id.text);
        convertView.setTag(viewHolderItem);
    }


    @Override
    public void exercise() {

        //ViewHolderSample viewholder = new ViewHolderSample();
        ViewHolderSample.Adapter holder = new ViewHolderSample.Adapter(activity);
        holder.getView(position, convertView, parent);
    }
}
