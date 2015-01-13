/**
 * TODO description
 */
public class ConstantPool extends java.util.HashMap<Short, Short>{
	
	public static final short CONST_SYSTEM_EXIT = 6662;
	public static final short CONST_SYSTEM_WRITE = 6663;

	/*
	 * 101 | System Exit			(CONST INT 6662)
	 * 102 | System Write			(CONST INT 6663)
	 */	

	public void registerConstants() {
		original();
		super.put((short) 101, CONST_SYSTEM_EXIT);
		super.put((short) 102, CONST_SYSTEM_WRITE);
	}
	
}