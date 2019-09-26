private Handler mHandler = new Handler() {
    public void handleMessage(Message msg) {
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
};