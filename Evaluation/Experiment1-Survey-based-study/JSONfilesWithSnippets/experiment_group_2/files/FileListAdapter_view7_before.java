public class FileListAdapter extends BaseAdapter {
	private final Context context;
	private final File[] data; 

	public FileListAdapter(Context context, File[] values) {
		this.context = context;
		this.data = values;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		View rowView = inflater.inflate(R.layout.list_row, parent, false);

		File f = data[position];
		
		TextView textView = (TextView) rowView.findViewById(R.id.file_name);
		TextView fullPath = (TextView) rowView.findViewById(R.id.full_path);
		ImageView imageView = (ImageView) rowView.findViewById(R.id.file_image);
		
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