import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

private class MyFragmentPagerAdapter extends FragmentStatePagerAdapter {

	private Map<Integer, WeakReference<CardFragment>> mPageReferenceMap = new HashMap<Integer, WeakReference<CardFragment>>();
		
	public MyFragmentPagerAdapter(FragmentManager fm) {
		super(fm);
	}
}