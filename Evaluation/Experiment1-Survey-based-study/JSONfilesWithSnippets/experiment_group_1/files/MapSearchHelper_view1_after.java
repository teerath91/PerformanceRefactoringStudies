@Override
public View getView(final int position, View convertView, final ViewGroup parent) {
    ViewHolderItem viewHolderItem;
    if (convertView == null) {
        convertView = vi.inflate(R.layout.map_search_results_list_item, null);
        viewHolderItem = new ViewHolderItem();
        viewHolderItem.tv = (TextView) convertView.findViewById(R.id.txtMapSearchResult);
        viewHolderItem.iv = (ImageView) convertView.findViewById(R.id.imgMapSearchIcon);
        convertView.setTag(viewHolderItem);
    } 
    else {
        viewHolderItem = (ViewHolderItem) convertView.getTag();
    }
    View row = convertView;
    TextView tv = viewHolderItem.tv;
    SearchResult sr = getItem(position);
    tv.setText(sr.description);

    ImageView iv = viewHolderItem.iv;
    if(sr.type == SearchResult.TYPE_STOP) {
        iv.setImageResource(R.drawable.mapmarker);
    }
     else {
        iv.setImageResource(R.drawable.house);
    }

    return row;
}