public static void setServiceNotificationAll(Context inContext){
	long tmpNotification = -1;
	Uri tmpItemUri = null;
	//Creating SQL cursor
	Cursor tmpCursor = inContext.getContentResolver().query(
			ContentProviderM.ITEM_CONTENT_URI, null, null, null, ContentProviderM.sSortType);
	if(tmpCursor.getCount() == 0){
	//tmpCursor.close();
		return;
	}
	//Iterating through all the database rows..
	for(tmpCursor.moveToFirst(); tmpCursor.isAfterLast() == false; tmpCursor.moveToNext()){
	//..extracting notification data and list item URI
		tmpNotification = tmpCursor.getLong(tmpCursor.getColumnIndexOrThrow(ItemTableM.COLUMN_NOTIFICATION));
		tmpItemUri = Uri.withAppendedPath(
				ContentProviderM.ITEM_CONTENT_URI,
				"/" +
				(tmpCursor.getLong(tmpCursor.getColumnIndexOrThrow(ItemTableM.COLUMN_ID))));
		//..if the notification is active, calling setServiceNotificationSingle
		if(tmpNotification > -1){
			setServiceNotificationSingle(inContext, tmpItemUri, tmpNotification);
		}
	}
	//tmpCursor.close();
}