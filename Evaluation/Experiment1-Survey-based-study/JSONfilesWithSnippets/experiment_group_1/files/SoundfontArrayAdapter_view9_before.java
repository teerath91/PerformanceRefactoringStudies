public class SoundfontArrayAdapter extends ArrayAdapter<String> {  

	public interface SoundfontArrayAdapterListener{
		public void setEnabled(int position, boolean yes);
	}
	SoundfontArrayAdapterListener mc;
	private LayoutInflater inflater;  
	public SoundfontArrayAdapter(SoundfontArrayAdapterListener c, Context context, List<String> sfList ) {
		super( context, R.layout.row_check, R.id.checkText, sfList );  
	    mc=c;
	    // Cache the LayoutInflate to avoid asking for a new one each time.  
	    inflater = LayoutInflater.from(context) ;  
	}  

	@Override  
	public View getView(final int position, View convertView, ViewGroup parent) {  
	    // Planet to display  
	    final String sfName = this.getItem( position );   
	    // The child views in each row.  
	    ToggleButton switchy ;   
	    TextView textView ;   
	    // Create a new row view  
	    convertView = inflater.inflate(R.layout.row_check, null);  
	    // Find the child views.  
	    textView = (TextView) convertView.findViewById( R.id.checkText );  
	    switchy = (ToggleButton) convertView.findViewById( R.id.sfSwitch );  
	          
	    switchy.setOnClickListener( new View.OnClickListener() {  
	    	public void onClick(View v) {  
	    		ToggleButton cb = (ToggleButton) v ;  
	    		mc.setEnabled(position, cb.isChecked());
	    	}  
	    });

	    	switchy.setChecked( !sfName.startsWith("#") );  
			textView.setText( sfName.substring(sfName.lastIndexOf('/')+1));   
		return convertView;  
	}  
}  