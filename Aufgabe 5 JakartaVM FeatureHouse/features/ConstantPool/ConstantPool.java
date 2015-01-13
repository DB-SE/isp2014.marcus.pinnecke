/**
 * TODO description
 */
public class ConstantPool extends java.util.HashMap<Short, Short>{

	public ConstantPool() {
		registerConstants();
	}
		
	public void registerConstants() {}
	
	@Override
	public Short get(Object key) {
		if (!super.containsKey(key)) {
			System.err.println("Unknown type index: " + key);
			System.exit(202);
		}
		return super.get(key);
	}
	
}