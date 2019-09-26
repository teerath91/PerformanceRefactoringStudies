Paint paint = new Paint();

@Override
protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    paint.setColor(Color.WHITE);
    paint.setTextSize(16);
    canvas.drawText("" + soundGenerators.get(0).getOscillator().getFrequency(), getWidth() / 2, getHeight() / 2, paint);
}