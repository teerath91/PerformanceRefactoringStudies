import java.lang.ref.WeakReference;
import android.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

private class MyFragmentPagerAdapter extends FragmentStatePagerAdapter {

	private SparseArray<WeakReference<CardFragment>> mPageReferenceMap = new SparseArray<WeakReference<CardFragment>>();
		
	public MyFragmentPagerAdapter(FragmentManager fm) {
		super(fm);
	}
}	