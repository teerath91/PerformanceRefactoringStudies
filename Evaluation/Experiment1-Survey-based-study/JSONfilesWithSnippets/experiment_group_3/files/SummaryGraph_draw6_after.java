Path p = new Path();

@Override
protected void onDraw(Canvas canvas) {
		
	paint.setAntiAlias(true);
	paint.setTextAlign(Align.CENTER);
	// normal
	paint.setStrokeWidth(0);

	float height = getHeight() - 24.0f;
	float height0 = height - 26.0f;
	float width = getWidth();

	// vertical lines
	//canvas.drawLine(0, 0, width, height, paint);
	//canvas.drawLine(0, height, width, 0, paint);
	paint.setStrokeWidth(2);
	paint.setStyle(Paint.Style.STROKE);  
	paint.setColor(getResources().getColor(android.R.color.holo_blue_light));
	canvas.drawRect(0, 0, width, height, paint);
	paint.setStyle(Paint.Style.FILL);  
	paint.setTextSize(18.0f);
	int len = this.data.size();
		
	p.moveTo(0, height);
	float oldH = height;
		
	for (int i=0; i < len; i++) {
		int val = this.data.get(i);
		float h = (height0-val/(1.0f*this.maximum)*height0) + 26.0f;
		float x0 = (i)*width/len;
		float x = (i+0.5f)*width/len;
		p.cubicTo(x0, oldH, x0, h, x, h);
		oldH = h;
	}
}