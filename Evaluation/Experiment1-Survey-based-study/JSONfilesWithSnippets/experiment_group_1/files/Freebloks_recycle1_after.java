boolean restoreOldGame() throws Exception {
	try {
		FileInputStream fis = openFileInput(FreebloksActivity.GAME_STATE_FILE);
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		Parcel p = Parcel.obtain();
		byte[] b = new byte[1024];
		int bytesRead;
		while ((bytesRead = fis.read(b)) != -1) {
			bos.write(b, 0, bytesRead);
		}
		fis.close();
		fis = null;
			
		byte[] bytes = bos.toByteArray();
		bos.close();
		bos = null;
			
		Bundle bundle;
		p.unmarshall(bytes, 0, bytes.length);
		p.setDataPosition(0);
		bundle = p.readBundle(FreebloksActivity.class.getClassLoader());
		if (p != null) {
			p.recycle();
		}
		deleteFile(GAME_STATE_FILE);
		if (readStateFromBundle(bundle)) {
			return true;
		} 
		else {
			return false;
		}
	} 
	catch (FileNotFoundException fe) {
		/* signal non-failure if game state file is missing */
		return false;
	} 
	catch (Exception e) {
		e.printStackTrace();
		throw e;
	}		
}