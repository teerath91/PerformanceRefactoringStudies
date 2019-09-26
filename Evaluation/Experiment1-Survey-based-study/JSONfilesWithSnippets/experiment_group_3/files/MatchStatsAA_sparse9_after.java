public class MatchStatsAA extends MatchStatsStruct {

	public int auto_high;
	public int auto_high_hot;
	public int auto_low;
	public int auto_low_hot;
	public int high;
	public int low;
	public boolean auto_mobile;

	public SparseArray<CycleStatsStruct> cycles;

	public MatchStatsAA() {
		init();
	}

	public MatchStatsAA(int team, String event, int match) {
		super(team, event, match);
		init();
	}

	public MatchStatsAA(int team, String event, int match, boolean auto) {
		super(team, event, match, auto);
		init();
	}

	public void init() {
		super.init();
		auto_high = 0;
		auto_high_hot = 0;
		auto_low = 0;
		auto_low_hot = 0;
		high = 0;
		low = 0;
		auto_mobile = false;
		cycles = new SparseArray<CycleStatsStruct>();
	}
}