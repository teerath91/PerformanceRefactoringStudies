private static class handlerCloseThreadforce1 extends Handler {
	private final WeakReference<NanoConverter> mActivity;

	public handlerCloseThreadforce1(NanoConverter activity) {
		mActivity = new WeakReference<NanoConverter>(activity);
	}

	@Override
	public void handleMessage(Message msg) {
		NanoConverter activity = mActivity.get();
		if (activity != null) {
			super.handleMessage(msg);
			progressDialog.dismiss();
		}
	}
}

handlerCloseThreadforce1 handlerCloseThreadforce = new handlerCloseThreadforce1(this);
    
private static class handlerCloseforce1 extends Handler {
	private final WeakReference<NanoConverter> mActivity;

	public handlerCloseforce1(NanoConverter activity) {
		mActivity = new WeakReference<NanoConverter>(activity);
	}

	@Override
	public void handleMessage(Message msg) {
		NanoConverter activity = mActivity.get();
		if (activity != null) {
			super.handleMessage(msg);
			handlerCloseThreadforce.sendEmptyMessage(0);
		}
	}
}

handlerCloseforce1 handlerCloseforce = new handlerCloseforce1(this);