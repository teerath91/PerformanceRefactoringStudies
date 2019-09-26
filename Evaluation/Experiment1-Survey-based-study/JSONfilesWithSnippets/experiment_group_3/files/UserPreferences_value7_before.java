public DateTime getExperimentListRefreshTime(String refreshType) {
  Long lastRefresh;
  if (refreshType.equals(FIND_EXPERIMENTS)) {
    lastRefresh = getAppPrefs().getLong(FIND_LAST_LIST_REFRESH_PREFERENCE_KEY, -1);
  } else {
    lastRefresh = getAppPrefs().getLong(JOIN_LAST_LIST_REFRESH_PREFERENCE_KEY, -1);
  }

  if (lastRefresh.equals(new Long(-1))) {
    return null;
  }
  return new DateTime(lastRefresh);
}