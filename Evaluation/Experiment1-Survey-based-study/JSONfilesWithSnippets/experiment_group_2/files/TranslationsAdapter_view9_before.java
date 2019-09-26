import java.util.List;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class TranslationsAdapter extends BaseAdapter{
    final private Activity mActivity;
    final private List<Translation>  mTranslations; 

    public TranslationsAdapter(Activity activity, List<Translation> translations){
        this.mActivity = activity;
        this.mTranslations = translations;
    }

    public int getCount() {
        return mTranslations.size();
    }

    public Object getItem(int position) {
        return mTranslations.get(position);
    }

	@Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = mActivity.getLayoutInflater();
        TextView view = (TextView)inflater.inflate(android.R.layout.simple_list_item_1, null);
        view.setText(mTranslations.get(position).getRequest());
        return view;
    }

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}
}