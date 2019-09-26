private static class communicatorServiceHandler1 extends Handler {
	private final WeakReference<FlairWidgetService> mActivity;

	public communicatorServiceHandler1(FlairWidgetService activity) {
		mActivity = new WeakReference<FlairWidgetService>(activity);
	}

	public void handleMessage(Message message) {
		FlairWidgetService activity = mActivity.get();
		if (activity != null) {
			if (message == null) {
				return;
			}
			int actionHash = message.what;
			if (IntentAction.WebService.IMAGE_DOWNLOAD.hashCode() == actionHash) {
				if (message.arg1 == WSConstants.Result.OK) {
					Dbug.log("WebService IMAGE_DOWLOAD -> SUCCESS");
					Bitmap bmpFlair = (Bitmap) message.obj;
					updateWidget(bmpFlair);
				}
				else {
					Dbug.log("WebService IMAGE_DOWLOAD -> ERROR");
				}
			}
		}
	}
}

private communicatorServiceHandler1 communicatorServiceHandler = new communicatorServiceHandler1(this);