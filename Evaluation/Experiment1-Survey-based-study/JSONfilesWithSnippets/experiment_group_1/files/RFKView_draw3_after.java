Rect r = new Rect();
@Override
protected void onDraw(Canvas canvas) {
	super.onDraw(canvas);
		
	if (width == -1){
		width = getWidth()/cellWidth;
		height = getHeight()/cellHeight;
	}

	background.setARGB(255, 0, 0, 0);
	getContext().getTheme();
		
	canvas.drawPaint(background);
		
	for (Thing thing: things){
		if (thing.x == -1){
			placeThing(thing);
		}
		Paint paint;
		if (thing.type == ThingType.ROBOT){
			paint = robotPaint;
			r.bottom = (thing.y + 1) * cellHeight + 2;
			r.right = thing.x * cellWidth;
			r.top = (thing.y) * cellHeight + 2;
			r.left = (thing.x-1) * cellWidth;
			canvas.drawRect(r, robotBg);
		}
		else{
			paint = thingPaint;
			paint.setColor(thing.color);
		}
		canvas.drawText(thing.character, thing.x * cellWidth, (1+thing.y) * cellHeight, paint);
	}
}