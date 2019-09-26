public class FileListAdapter extends BaseAdapter {
	private final Context context;
	private final File[] data; 

	public FileListAdapter(Context context, File[] values) {
		this.context = context;
		this.data = values;
	}

	static class ViewHolderItem {
		TextView textView;
		TextView fullPath;
		ImageView imageView;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		ViewHolderItem viewHolderItem;
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		if (convertView == null) {
			convertView = inflater.inflate(R.layout.list_row, parent, false);
			viewHolderItem = new ViewHolderItem();
			viewHolderItem.textView = (TextView) convertView.findViewById(R.id.file_name);
			viewHolderItem.fullPath = (TextView) convertView.findViewById(R.id.full_path);
			viewHolderItem.imageView = (ImageView) convertView.findViewById(R.id.file_image);
			convertView.setTag(viewHolderItem);
		} else {
			viewHolderItem = (ViewHolderItem) convertView.getTag();
		}
		View rowView = convertView;
		File f = data[position];
		
		TextView textView = viewHolderItem.textView;
		TextView fullPath = viewHolderItem.fullPath;
		ImageView imageView = viewHolderItem.imageView;
		
		textView.setText(f.getName());
		fullPath.setText(f.getAbsolutePath());
		imageView.setImageResource(
				BrowseHandler.getFileIconResourceId(f.getAbsolutePath()));

		return rowView;

	}

	public int getCount() {
		return data.length;
	}

	public Object getItem(int position) {
		return position;
	}

	public long getItemId(int position) {
		return position;
	}

}