/**
 * TODO description
 */
public class ConstantPool extends java.util.HashMap<Short, Short>{
	
	public static final short CONST_SANDBOX_WRITE = 6661;

	/*
	 * 100 | Sandbox Write			(CONST INT 6661)
	 */	

	public void registerConstants() {
		original();
		super.put((short) 100, CONST_SANDBOX_WRITE);
	}
	
}