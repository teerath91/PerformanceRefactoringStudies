private static IntegerConverter integerConverterforClassName(Reflector reflector, String className){
	if(_integerConverters == null){
		_integerConverters = new Hashtable4();
		IntegerConverter[] converters = new IntegerConverter[]{
			new IntegerConverter(){
				@Override
				public String primitiveName() {return int.class.getName();}
				@Override
				public Object fromInteger(int i) {return new Integer(i);}
			},
			new IntegerConverter(){
				@Override
				public String primitiveName() {return long.class.getName();}
				@Override
				public Object fromInteger(int i) {return new Long(i);}
			},
			new IntegerConverter(){
				@Override
				public String primitiveName() {return double.class.getName();}
				@Override
				public Object fromInteger(int i) {return new Double(i);}
			},
			new IntegerConverter(){
				@Override
				public String primitiveName() {return float.class.getName();}
				@Override
				public Object fromInteger(int i) {return new Float(i);}
			},
			new IntegerConverter(){
				@Override
				public String primitiveName() {return byte.class.getName();}
				@Override
				public Object fromInteger(int i) {return new Byte((byte)i);}
			},
			new IntegerConverter(){
				@Override
				public String primitiveName() {return char.class.getName();}
				@Override
				public Object fromInteger(int i) {return new Character((char)i);}
			},
			new IntegerConverter(){
				@Override
				public String primitiveName() {return short.class.getName();}
				@Override
				public Object fromInteger(int i) {return new Short((short)i);}
			},
			new IntegerConverter(){
				@Override
				public String primitiveName() {return String.class.getName();}
				@Override
				public Object fromInteger(int i) {return STRING_IDENTIFIER + i;}
				@Override
				public int toInteger(Object obj) {
					if(! (obj instanceof String)){
						return -1;
					}
					String str = (String)obj;
					if(str.length() < STRING_IDENTIFIER.length()){
						return -1;
					}
					if(str.indexOf(STRING_IDENTIFIER) != 0){
						return -1;
					}
					return Integer.parseInt(str.substring(STRING_IDENTIFIER.length()));
				}
			},
		};
		for (IntegerConverter converter : converters) {
			_integerConverters.put(converter.primitiveName(), converter);
			if(! converter.primitiveName().equals(converter.wrapperName(reflector))){
				_integerConverters.put(converter.wrapperName(reflector), converter);
			}
		}
	}
	return (IntegerConverter) _integerConverters.get(className);
}