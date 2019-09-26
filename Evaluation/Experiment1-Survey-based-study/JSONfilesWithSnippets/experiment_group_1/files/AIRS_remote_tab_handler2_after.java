private static class mHandler1 extends Handler {
    private final WeakReference<AIRS_remote_tab> mActivity;

    public mHandler1(AIRS_remote_tab activity) {
        mActivity = new WeakReference<AIRS_remote_tab>(activity);
    }

    @Override
    public void handleMessage(Message msg) {
        AIRS_remote_tab activity = mActivity.get();
        if (activity != null) {
            switch (msg.what) {
                case START_REMOTELY:
                    AIRS_remotely.started = true;
                    startService(new Intent(airs, AIRS_remote.class));
                    progressdialog.cancel();
                    finish();
                    break;
                default:
                    break;
            }
        }
    }
}

public final mHandler1 mHandler = new mHandler1(this);