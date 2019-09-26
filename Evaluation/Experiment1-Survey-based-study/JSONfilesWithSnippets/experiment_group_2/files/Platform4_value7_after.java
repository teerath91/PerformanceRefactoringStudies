 private static void initNullValues() {
    _nullValues = new Hashtable4();
    _nullValues.put(boolean.class, Boolean.FALSE);
    _nullValues.put(byte.class, Byte.valueOf((byte)0));
    _nullValues.put(short.class, Short.valueOf((short)0));
    _nullValues.put(char.class, Character.valueOf((char)0));
    _nullValues.put(int.class, Integer.valueOf(0));
    _nullValues.put(float.class, Float.valueOf((float) 0.0));
    _nullValues.put(long.class, Long.valueOf(0));
    _nullValues.put(double.class, Double.valueOf(0.0));
}