public GameView(Context context) {
	super(context);
	prefs = PreferenceManager.getDefaultSharedPreferences(context);
	ui = (UI) context;
	setWillNotDraw(false);
	setLayoutParams( new FrameLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT, Gravity.TOP));
	Display display = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
//	Log.i(tag, "width : " + display.getWidth() + ", height : " + display.getHeight());

	setBackgroundResource(R.layout.linear_gradient);
	getBackground().setDither(true);
		
	game = new Game();
	ai = new AI(game);
	dI = display.getWidth()/sizeI;
	dJ = new Double(0.8660254*dI).intValue();
	diameter = new Double( 0.96*dI).intValue();
	Log.i(tag, "width : " + display.getWidth() + ", height : " + display.getHeight() + ", dI : " + dI + ", dJ : " + dJ);
		
	buttons = new ButtonsView(context);
	addView( buttons);
		
	BitmapFactory.Options opts = new BitmapFactory.Options();
    opts.inJustDecodeBounds = true;
    hole = BitmapFactory.decodeResource(context.getResources(), R.drawable.steel);
    iconSelected = BitmapFactory.decodeResource(context.getResources(), R.drawable.ring2);
    iconPointed = BitmapFactory.decodeResource(context.getResources(), R.drawable.ring3);

	paint.setStrokeWidth(0.2f);
	paint.setColor(Color.BLACK);

	for (int color=0; color<6; color++) {
		balls[color] = BitmapFactory.decodeResource(context.getResources(), icons[color]);
	}
}