package nl.vu.cs.appafterhandlerleak;

import android.os.Handler;
import android.os.Message;

import java.lang.ref.WeakReference;

public class HandlerLeakSample{

    private static class communicatorServiceHandler1 extends Handler {
        private final WeakReference<HandlerLeakSample> mActivity;

        public communicatorServiceHandler1(HandlerLeakSample activity) {
            mActivity = new WeakReference<HandlerLeakSample>(activity);
        }

        public void handleMessage(Message message) {
            HandlerLeakSample activity = mActivity.get();
            if (activity != null) {
                if (message == null) {
                    return;
                }
            }
        }
    }

    private communicatorServiceHandler1 communicatorServiceHandler = new communicatorServiceHandler1(this);

    public void start_sensing()
    {
        Integer AIRS_locally = 4;
        if (AIRS_locally != null)
        {
            Message msg = communicatorServiceHandler.obtainMessage();
            communicatorServiceHandler.sendMessage(msg);
        }
    }
}
