public static String getConfigNameFromID(int config, SQLiteDatabase db) {

	String[] projection = { CONFIGURATION_LU_Entry.COLUMN_NAME_CONFIGURATION_DESC };
	String[] where = { String.valueOf(config) };
	Cursor c = db.query(CONFIGURATION_LU_Entry.TABLE_NAME, projection, // select
			CONFIGURATION_LU_Entry.COLUMN_NAME_ID + "= ?", where, // EventName
			null, // don't group
			null, // don't filter
			null, // don't order
			"0,1"); // limit to 1
	c.moveToFirst();
	if (c != null) {
		c.close();
	}
	return c.getString(c
			.getColumnIndexOrThrow(CONFIGURATION_LU_Entry.COLUMN_NAME_CONFIGURATION_DESC));
}