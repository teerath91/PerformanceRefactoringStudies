import java.util.HashMap;

import java.util.Map;

import de.skubware.opentraining.R;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ExerciseImageListAdapter extends BaseAdapter{

	static class ViewHolderItem {
		ImageView imageView;
	}

	public View getView(final int position, View convertView, ViewGroup parent) {
		ViewHolderItem viewHolderItem;
		if (convertView == null) {
			convertView = mInflater.inflate(de.skubware.opentraining.R.layout.exercise_image_list_row, null);
			viewHolderItem = new ViewHolderItem();
			viewHolderItem.imageView = (ImageView) convertView.findViewById(R.id.exercise_image);
			convertView.setTag(viewHolderItem);
		} else {
			viewHolderItem = (ViewHolderItem) convertView.getTag();
		}
		View vi = convertView;
		ImageView imageView = viewHolderItem.imageView;
		imageView.setImageBitmap(getBitmap(position));
		imageView.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				ShowImageDialog.showImageDialog(getBitmap(position), mContext);
			}
		});


		return vi;

	}

	public void remove(String name) {
		mNameImageMap.remove(name);
	}	
	
	public void remove(int position){
		mNameImageMap.remove(getImageName(position));
	}

	
}
