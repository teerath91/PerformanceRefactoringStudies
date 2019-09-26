public final Handler mHandler = new Handler() 
{
  @Override
  public void handleMessage(Message msg) 
  {
    switch (msg.what) 
    {
      case START_REMOTELY:
        AIRS_remotely.started = true;
        
        // start service 
        startService(new Intent(airs, AIRS_remote.class));

        // stop progress dialog
        progressdialog.cancel();

        // stop activity
        finish();
        break;
      default:
        break;
    }
  }
};