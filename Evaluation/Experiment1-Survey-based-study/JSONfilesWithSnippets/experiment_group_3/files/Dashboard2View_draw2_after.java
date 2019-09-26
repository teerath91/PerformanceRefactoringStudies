@Override
protected void onDraw(Canvas c) {
	super.onDraw(c);
		
	a += textSizeSmall;
	p.setTextSize(textSizeSmall);
	c.drawText(context.getString(R.string.TxRSSI), 0, a, p);

	a += 5;
	p.setTextSize(textSizeMedium);
	c.drawRect(0, a, 150, a+textSizeSmall, p);
	c.drawRect(0, a, (int) map(TXRSSI,0,110,0,150), a+textSizeSmall, p4);
		
	a += textSizeSmall*2;
	p.setTextSize(textSizeSmall);
	c.drawText(context.getString(R.string.RxRSSI), 0, a, p);

	a += 5;
	p.setTextSize(textSizeMedium);
	c.drawRect(0, a, 150, a+textSizeSmall, p);
	c.drawRect(0, a, (int) map(RXRSSI,0,110,0,150), a+textSizeSmall, p4);

	a = hh - textSizeMedium;
	p.setTextSize(textSizeSmall);
	c.drawText(context.getString(R.string.LatxLon), 0, a, p);

	a = hh;
	p.setTextSize(textSizeMedium);
	c.drawText(format.format(Lat / Math.pow(10, 7)) + " x " + format.format(Lon / Math.pow(10, 7)), 0, a, p);
}