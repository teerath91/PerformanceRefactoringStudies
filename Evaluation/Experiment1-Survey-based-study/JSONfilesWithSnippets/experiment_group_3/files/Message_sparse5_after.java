lstview.setMultiChoiceModeListener(new MultiChoiceModeListener() {

	SparseBooleanArray selectedList = new SparseBooleanArray();

	@Override
	public void onItemCheckedStateChanged(ActionMode mode,
			int position, long id, boolean checked) {
		// Here you can do something when items are
		// selected/de-selected,
		// such as update the title in the CAB
		selectedList.put(position, checked);
		if (checked) {
			selectedCounter++;
		} else {
			selectedCounter--;
		}
		if (selectedCounter != 0) {
			mode.setTitle(selectedCounter + "");
		}

	}
}