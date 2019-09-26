private static void initNullValues() {
    _nullValues = new Hashtable4();
     _nullValues.put(boolean.class, Boolean.FALSE);
     _nullValues.put(byte.class, new Byte((byte)0));
     _nullValues.put(short.class, new Short((short)0));
     _nullValues.put(char.class, new Character((char)0));
     _nullValues.put(int.class, new Integer(0));
     _nullValues.put(float.class, new Float(0.0));
     _nullValues.put(long.class, new Long(0));
     _nullValues.put(double.class, new Double(0.0));
}