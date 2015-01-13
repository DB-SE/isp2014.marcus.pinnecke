/**
 * TODO description
 */
public class ConstantPool extends java.util.HashMap<Short, Short>{
	
	public static final short CONST_INTEGER = 10;
	public static final short CONST_FLOAT = 11;
	public static final short CONST_LONG = 12;
	public static final short CONST_DOUBLE = 13;
	public static final short CONST_STRING = 14;

	/*
	 * 3	|	Int					(CONST INT 10)
	 * 4	| 	Float				(CONST INT 11)
	 * 5	|	Long				(CONST INT 12)
	 * 6	| 	Double				(CONST INT 13)
	 * 7	|	String				(CONST INT 14)
	 */	

	public void registerConstants() {
		original();
		super.put((short) 3, CONST_INTEGER);
		super.put((short) 4, CONST_FLOAT);
		super.put((short) 5, CONST_LONG);
		super.put((short) 6, CONST_DOUBLE);
		super.put((short) 7, CONST_STRING);
	}
	
}