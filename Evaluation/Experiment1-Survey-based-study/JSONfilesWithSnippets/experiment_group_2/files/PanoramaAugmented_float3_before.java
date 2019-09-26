PixelsShiftX = angleX * R;
PixelsShiftY = angleY * R;

CameraController.Size imageSize = CameraController.getCameraImageSize();
				// convert rotation around center into rotation around top-left corner
PixelsShiftX += imageSize.getWidth() / 2 * (1 - FloatMath.cos(angleR))
	+ imageSize.getHeight() / 2 * FloatMath.sin(angleR);
PixelsShiftY += -imageSize.getWidth() / 2 * FloatMath.sin(angleR) + imageSize.getHeight()
	/ 2 * (1 - FloatMath.cos(angleR));

PluginManager.getInstance().addToSharedMem("pano_frame" + (frame_cursor + 1) + "." + SessionID,
	String.valueOf(frame.getNV21address()));

PluginManager.getInstance().addToSharedMem("pano_frametrs" + (frame_cursor + 1) + ".00." + SessionID,
	String.valueOf(FloatMath.cos(angleR)));
PluginManager.getInstance().addToSharedMem("pano_frametrs" + (frame_cursor + 1) + ".01." + SessionID,
	String.valueOf(-FloatMath.sin(angleR)));
PluginManager.getInstance().addToSharedMem("pano_frametrs" + (frame_cursor + 1) + ".02." + SessionID,
	String.valueOf(PixelsShiftX));
PluginManager.getInstance().addToSharedMem("pano_frametrs" + (frame_cursor + 1) + ".10." + SessionID,
	String.valueOf(FloatMath.sin(angleR)));
PluginManager.getInstance().addToSharedMem("pano_frametrs" + (frame_cursor + 1) + ".11." + SessionID,
	String.valueOf(FloatMath.cos(angleR)));
PluginManager.getInstance().addToSharedMem("pano_frametrs" + (frame_cursor + 1) + ".12." + SessionID,
	String.valueOf(PixelsShiftY));
PluginManager.getInstance().addToSharedMem("pano_frametrs" + (frame_cursor + 1) + ".20." + SessionID,
	String.valueOf(0.0f));
PluginManager.getInstance().addToSharedMem("pano_frametrs" + (frame_cursor + 1) + ".21." + SessionID,
	String.valueOf(0.0f));
PluginManager.getInstance().addToSharedMem("pano_frametrs" + (frame_cursor + 1) + ".22." + SessionID,
	String.valueOf(1.0f));
