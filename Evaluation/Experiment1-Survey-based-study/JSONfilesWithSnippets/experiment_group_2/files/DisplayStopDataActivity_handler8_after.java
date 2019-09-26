private static class mHandler1 extends Handler {
    private final WeakReference<DisplayStopDataActivity> mActivity;

    public mHandler1(DisplayStopDataActivity activity) {
        mActivity = new WeakReference<DisplayStopDataActivity>(activity);
    }

    @Override
    public void handleMessage(final Message msg) {
        DisplayStopDataActivity activity = mActivity.get();
        if (activity != null) {
            switch (msg.what) {
                case EVENT_REFRESH:
                    showDialog(DIALOG_PROGRESS);
                    busTimes.doRequest(new String[] { stopCode }, numDepartures);
                    break;
                case EVENT_UPDATE_TIME:
                    updateLastRefreshed();
                    setUpLastUpdated();
                    break;
                default:
                    break;
            }
        }
    }
}

private mHandler1 mHandler = new mHandler1(this);