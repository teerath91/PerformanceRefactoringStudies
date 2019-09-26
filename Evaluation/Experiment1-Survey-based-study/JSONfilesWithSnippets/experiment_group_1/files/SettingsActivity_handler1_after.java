private static class communicatorServiceHandler1 extends Handler {
	private final WeakReference<SettingsActivity> mActivity;

	public communicatorServiceHandler1(SettingsActivity activity) {
		mActivity = new WeakReference<SettingsActivity>(activity);
	}

	public void handleMessage(Message message) {
		SettingsActivity activity = mActivity.get();
		if (activity != null) {
			if (message == null) {
				return;
			}
			int actionHash = message.what;
			if (IntentAction.WebService.IMAGE_DOWNLOAD.hashCode() == actionHash) {
				if (message.arg1 == WSConstants.Result.OK) {
					Dbug.log("WebService IMAGE_DOWLOAD -> SUCCESS");
					Bitmap bmpFlair = (Bitmap) message.obj;
					prefFlairImage.setBitmap(bmpFlair);
				} 
				else {
					Dbug.log("WebService IMAGE_DOWLOAD -> ERROR");
				}
			}
		}
	}
}
private communicatorServiceHandler1 communicatorServiceHandler = new communicatorServiceHandler1(this);