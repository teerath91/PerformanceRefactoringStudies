public static String getFilePathFromIntent(Context inContext, Intent inIntent){
	Uri tmpUri = inIntent.getData();
	String retFilePath = "";
	Cursor tmpCursor = null;
	try{
		tmpCursor = inContext.getContentResolver().query(tmpUri, null, null, null, null);
		//-Please note that the sorttype is set to null here because this method will be
		// used for other content providers than our own
		tmpCursor.moveToFirst();
		retFilePath = tmpCursor.getString(tmpCursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA));
	}
	finally{
	//tmpCursor.close();
	}
	return retFilePath;
}	