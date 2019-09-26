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

   /* public String getItemId(int position) {
        return list_bsl.get(position).getName();
    }*/
	@Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View spinView = inflater.inflate(R.layout.spin_layout, null);
        //TextView t1 = (TextView) spinView.findViewById(R.id.field1);
        TextView t2 = (TextView) spinView.findViewById(R.id.field2);
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