private RectF viewRect;
private RectF mapRect;
RectF viewRect = new RectF();
RectF mapRect = new RectF();

@Override
protected void onDraw(Canvas canvas) {
	super.onDraw(canvas);
	canvas.save();
	viewRect.bottom = getHeight();
	viewRect.right = getWidth();
	viewRect.top = 0;
	viewRect.left = 0;
	long t0 = System.currentTimeMillis();
	mapRect.bottom = tileMap.yOff + tileSize * tileMap.rows * tileMap.scale;
	mapRect.right = tileMap.xOff + tileSize * tileMap.columns * tileMap.scale;
	mapRect.top = tileMap.yOff;
	mapRect.left = tileMap.xOff;
	if (mapRect.intersect(viewRect)) {
		canvas.drawRect(mapRect, emptyTilePaint);
	}
	long t1 = System.currentTimeMillis();
	Log.d(TAG, "time to fill map background: " + (t1 - t0) + " ms.");
	t0 = System.currentTimeMillis();
	for (int rowIdx = 0; rowIdx < tileMap.rows; rowIdx++) {
		for (int colIdx = 0; colIdx < tileMap.columns; colIdx++) {
			if (tileMap.tilePaths[rowIdx][colIdx] != null) {
				float left = tileMap.xOff + tileSize * colIdx * tileMap.scale;
				float top = tileMap.yOff + tileSize * rowIdx * tileMap.scale;
				float width = tileSize * tileMap.scale;
				float height = width;
				if (viewRect.intersects(left, top, left + width, top + height)) {
					Matrix m = tileMap.tileMatrices[rowIdx][colIdx];
					Log.d(TAG, "angle: " + tileMap.tileAngles[rowIdx][colIdx] + " => "
						+ (90 * tileMap.tileAngles[rowIdx][colIdx]));
					m.reset();
					m.postRotate(90 * tileMap.tileAngles[rowIdx][colIdx]);
					m.preScale(tileMap.scale, tileMap.scale);
					Bitmap scaled = Bitmap.createBitmap(tileMap.tileBitmaps[rowIdx][colIdx], 0, 0, tileSize, tileSize, m, true);
					canvas.drawBitmap(scaled, left, top, debugPaint);
					scaled.recycle();
					}
				}
			}
		}
	}
}