private Handler mHandler = new Handler() {
    @Override
    public void handleMessage(final Message msg) {
        switch(msg.what) {
            case EVENT_REFRESH:
                showDialog(DIALOG_PROGRESS);
                busTimes.doRequest(new String[] { stopCode },
                        numDepartures);
                break;
            case EVENT_UPDATE_TIME:
                updateLastRefreshed();
                setUpLastUpdated();
                break;
            default:
                break;
        }
    }
};