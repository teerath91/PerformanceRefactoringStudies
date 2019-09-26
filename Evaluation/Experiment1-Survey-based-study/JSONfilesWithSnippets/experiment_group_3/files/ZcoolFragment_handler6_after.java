private static class mHandler1 extends Handler {
    private final WeakReference<ZcoolFragment> mActivity;

    public mHandler1(ZcoolFragment activity) {
        mActivity = new WeakReference<ZcoolFragment>(activity);
    }

    public void handleMessage(Message msg) {
        ZcoolFragment activity = mActivity.get();
        if (activity != null) {
            switch (msg.what) {
                case MSG_SUCCESS:
                    mAdapter.notifyDataSetChanged();
                    stopLoadingAnim();
                    break;
                case MSG_FAILURE:
                    showLoadingAnim();
                    break;
            }
        }
    }
}

private mHandler1 mHandler = new mHandler1(this);