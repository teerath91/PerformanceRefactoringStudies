package nl.vu.cs.apphandlerleak;

import android.os.Handler;
import android.os.Message;

public class HandlerLeakSample{

    private Handler communicatorServiceHandler = new Handler()
    {
        public void handleMessage(Message message)
        {
            // null check
            if (message == null)
            {
                return;
            }

        }
    };

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
