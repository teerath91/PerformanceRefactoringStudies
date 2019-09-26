import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.example.lexinproject.R;

public class LanguagesAdapter extends BaseAdapter implements SpinnerAdapter{
    private Activity activity;
    private Language[] list_bsl; 

    public LanguagesAdapter(Activity activity, Language[] list_bsl){
        this.activity = activity;
        this.list_bsl = list_bsl;
    }

    public int getCount() {
        return list_bsl.length;
    }

    public Object getItem(int position) {
        return list_bsl[position];
    }

   static class ViewHolderItem {
		TextView t2;
	}

	/* public String getItemId(int position) {
        return list_bsl.get(position).getName();
    }*/
	@Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolderItem viewHolderItem;
		LayoutInflater inflater = activity.getLayoutInflater();
        if (convertView == null) {
			convertView = inflater.inflate(R.layout.spin_layout, null);
			viewHolderItem = new ViewHolderItem();
			viewHolderItem.t2 = (TextView) convertView.findViewById(R.id.field2);
			convertView.setTag(viewHolderItem);
		} else {
			viewHolderItem = (ViewHolderItem) convertView.getTag();
		}
		View spinView = convertView;
		//TextView t1 = (TextView) spinView.findViewById(R.id.field1);
        TextView t2 = viewHolderItem.t2;
        //t1.setText(String.valueOf(list_bsl[position].getName()));
        t2.setText(list_bsl[position].getName());
        return spinView;
    }

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}
}