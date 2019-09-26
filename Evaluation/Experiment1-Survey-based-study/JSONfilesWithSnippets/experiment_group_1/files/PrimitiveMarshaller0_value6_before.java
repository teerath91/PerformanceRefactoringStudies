@Override
public Object readInteger(ByteArrayBuffer bytes) {
	final int value = bytes.readInt();
	if (value == Integer.MAX_VALUE) {
		return null;
	}
	return new Integer(value);
}

@Override
public Object readFloat(ByteArrayBuffer bytes) {
	Float value = unmarshallFloat(bytes);
	if (value.isNaN()) {
		return null;
	}
	return value;
}
	
@Override
public Object readDouble(ByteArrayBuffer buffer) {
	Double value = unmarshalDouble(buffer);
	if (value.isNaN()) {
		return null;
	}
	return value;
}	

@Override
public Object readLong(ByteArrayBuffer buffer) {
	long value = buffer.readLong();
	if (value == Long.MAX_VALUE) {
		return null;
	}
	return new Long(value);
}
	
@Override
public Object readShort(ByteArrayBuffer buffer) {
	short value = unmarshallShort(buffer);
	if (value == Short.MAX_VALUE) {
		return null;
	}
	return new Short(value);
}
	
public static Double unmarshalDouble(ByteArrayBuffer buffer) {
	return new Double(Platform4.longToDouble(buffer.readLong()));
}

public static Float unmarshallFloat(ByteArrayBuffer buffer) {
	return new Float(Float.intBitsToFloat(buffer.readInt()));
}	