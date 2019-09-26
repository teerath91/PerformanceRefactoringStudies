@Override
public View getView(final int position, View convertView, final ViewGroup parent) {
    View row = vi.inflate(R.layout.map_search_results_list_item, null);

    TextView tv = (TextView)row.findViewById(R.id.txtMapSearchResult);
    SearchResult sr = getItem(position);
    tv.setText(sr.description);

    ImageView iv = (ImageView)row.findViewById(R.id.imgMapSearchIcon);
    if(sr.type == SearchResult.TYPE_STOP) {
        iv.setImageResource(R.drawable.mapmarker);
    } 
    else {
        iv.setImageResource(R.drawable.house);
    }

    return row;
}