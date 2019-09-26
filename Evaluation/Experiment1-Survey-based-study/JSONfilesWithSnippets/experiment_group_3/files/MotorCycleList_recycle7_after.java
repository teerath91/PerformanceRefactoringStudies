@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_bikelist);

    String[] bikeName = getResources().getStringArray(R.array.bikeName);
    TypedArray bikeImage = getResources().obtainTypedArray(R.array.bikeImage);

    List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();
    b = new Bundle();
    for (int i = 0; i < bikeName.length; i++) {
        HashMap<String, String> hm = new HashMap<String, String>();
        hm.put(Constants.TAG_TXT, bikeName[i]);
        hm.put(Constants.TAG_IMAGE, Integer.toString(bikeImage.getResourceId(i, -1)));
        hm.put(Constants.TAG_CAT, "Category: " + bikeCategory[i]);
        aList.add(hm);
    }
    if (bikeImage != null) {
        bikeImage.recycle();
    }
    String[] from = {Constants.TAG_IMAGE, Constants.TAG_TXT, Constants.TAG_CAT};
    int[] to = {R.id.imageView_img, R.id.textView_bikeName, R.id.textView_category};
    SimpleAdapter adapter = new SimpleAdapter(getBaseContext(), aList, R.layout.simple_list_item, from, to);
    listView = (ListView) findViewById(R.id.listview_bike);
    listView.setAdapter(adapter);

    listViewItemSelect();
}