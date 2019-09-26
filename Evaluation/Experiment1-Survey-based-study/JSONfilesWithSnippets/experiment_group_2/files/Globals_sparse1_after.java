public static SparseIntArray validBuffers(int[] rates, boolean stereo, boolean sixteen)
{
	SparseIntArray buffers = new SparseIntArray();
	for(int rate : rates)
	{
		buffers.put(rate, AudioTrack.getMinBufferSize(rate, (stereo)?AudioFormat.CHANNEL_OUT_STEREO:AudioFormat.CHANNEL_OUT_MONO, (sixteen)?AudioFormat.ENCODING_PCM_16BIT:AudioFormat.ENCODING_PCM_8BIT));
	}
	return buffers;
}


public static boolean updateBuffers(int[] rata)
{
	if(rata!=null)
	{
	SparseIntArray buffMap = Globals.validBuffers(rata, prefs.getString("sdlChanValue","2").equals("2"), prefs.getString("tplusBits", "16").equals("16"));
	int realMin = buffMap.get(Integer.parseInt(prefs.getString("tplusRate", Integer.toString(AudioTrack.getNativeOutputSampleRate(AudioTrack.MODE_STREAM)))));
	if(buff<realMin)
	{
		prefs.edit().putString("tplusBuff", Integer.toString(buff=realMin)).commit();
		return false;
	}
	
	}
	return true;
}