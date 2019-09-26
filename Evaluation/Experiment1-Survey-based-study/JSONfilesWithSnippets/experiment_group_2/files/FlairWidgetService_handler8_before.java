private Handler communicatorServiceHandler = new Handler()
{

	public void handleMessage(Message message)
	{
		// null check
		if (message == null)
		{
			return;
		}

		// get info from message
		int actionHash = message.what;

		/* IMAGE_DOWNLOAD */
		if (IntentAction.WebService.IMAGE_DOWNLOAD.hashCode() == actionHash)
		{
			if (message.arg1 == WSConstants.Result.OK)
			{
				// download success - update image
				Dbug.log("WebService IMAGE_DOWLOAD -> SUCCESS");
				Bitmap bmpFlair = (Bitmap) message.obj;
				updateWidget(bmpFlair);
			}
			else
			{
				// download error
				Dbug.log("WebService IMAGE_DOWLOAD -> ERROR");
			}
		}

	}
};