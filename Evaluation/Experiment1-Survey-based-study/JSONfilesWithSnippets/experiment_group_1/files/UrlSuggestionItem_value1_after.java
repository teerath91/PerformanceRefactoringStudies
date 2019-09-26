package org.tint.model;

import java.util.Comparator;

public class UrlSuggestionItemComparator implements Comparator<UrlSuggestionItem> {

	@Override
	public int compare(UrlSuggestionItem object1, UrlSuggestionItem object2) {
		Float value1 = Float.valueOf(object1.getNote());
		Float value2 = Float.valueOf(object2.getNote());
		return value2.compareTo(value1);
	}

}