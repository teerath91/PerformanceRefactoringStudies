@Override
public void onStartTracking(MotionEvent event) {
	MotionEvent motionEvent = MotionEvent.obtain(event);
	motionEvent.setAction(MotionEvent.ACTION_CANCEL);
	if (motionEvent != null) {
		motionEvent.recycle();
	}
	SubjectCard.super.onTouchEvent(event);
}