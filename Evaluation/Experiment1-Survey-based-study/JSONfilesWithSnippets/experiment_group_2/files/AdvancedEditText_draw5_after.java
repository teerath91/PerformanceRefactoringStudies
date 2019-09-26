Rect lineBounds = new Rect(), drawing = new Rect();
public void onDraw(Canvas canvas) {
	int count, padding, lineX, baseline, selStart, selEnd;
	// padding
	count = getLineCount();
	padding = 5;
	if (Settings.SHOW_LINE_NUMBERS) {
		padding = (int) (Math.floor(Math.log10(count)) + 1);
		padding = (padding * (Settings.TEXT_SIZE - 2)) + mPadding
			+ (Settings.TEXT_SIZE / 2);
		setPadding(padding, mPadding, mPadding, mPadding);
	} 
	else {
		setPadding(mPadding, mPadding, mPadding, mPadding);
	}

	getDrawingRect(drawing);

	// display current line
	computeLineHighlight();

	// draw line numbers
	count = getLineCount();
	lineX = (drawing.left + padding - (Settings.TEXT_SIZE / 2));

	for (int i = 0; i < count; i++) {
		baseline = getLineBounds(i, lineBounds);
		if (mMaxSize != null)
			if (mMaxSize.x < lineBounds.right)
				mMaxSize.x = lineBounds.right;

		if (lineBounds.bottom < drawing.top)
			continue;
		if (lineBounds.top > drawing.bottom)
			continue;

		if (i == mHighlightedLine)
			canvas.drawRect(lineBounds, mPaintHighlight);

		if (Settings.SHOW_LINE_NUMBERS) {
			canvas.drawText("" + (i + 1), drawing.left + mPadding,
				baseline, mPaintNumbers);
		}
		if (Settings.SHOW_LINE_NUMBERS)
			canvas.drawLine(lineX, drawing.top, lineX, drawing.bottom,
				mPaintNumbers);
	}

	if (mMaxSize != null) {
		mMaxSize.y = lineBounds.bottom;
		mMaxSize.x = Math.max(mMaxSize.x + mPadding - drawing.width(), 0);
		mMaxSize.y = Math.max(mMaxSize.y + mPadding - drawing.height(), 0);
	}
	super.onDraw(canvas);
}