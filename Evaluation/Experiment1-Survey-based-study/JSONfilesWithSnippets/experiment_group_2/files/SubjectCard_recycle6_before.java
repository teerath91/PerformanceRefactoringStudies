@Override
public void onStartTracking(MotionEvent event) {
	MotionEvent motionEvent = MotionEvent.obtain(event);
	motionEvent.setAction(MotionEvent.ACTION_CANCEL);
	SubjectCard.super.onTouchEvent(event);
}