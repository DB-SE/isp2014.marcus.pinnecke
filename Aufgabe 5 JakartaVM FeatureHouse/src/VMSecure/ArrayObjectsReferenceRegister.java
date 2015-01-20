import java.util.HashMap; 

/**
 * TODO description
 */
public  class  ArrayObjectsReferenceRegister  extends
		java.util.HashMap<Short, Object[]> {
	
			
	private short nextRef = 0;

	
	private java.util.HashMap<Short, Integer> arrayTypes = new HashMap<Short, Integer>();

	
	
	private void checkRefAndPos(short ref, int pos) {
		if (!super.containsKey(ref)) {
			System.err.println("Unkown array reference:" + ref);
			System.exit(13);
		}
		if (pos < 0) {
			System.err.println("Negative array index.");
			System.exit(11);
		} else if (pos > super.get(ref).length - 1) {
			System.err.println("Array index out of bounds.");
			System.exit(12);
		}
	}

	
	
	public Object load(short ref, int pos) {
		checkRefAndPos(ref, pos);
		return super.get(ref)[pos];
	}

	
	
	public void store(short ref, int pos, Object value) {
		checkRefAndPos(ref, pos);
		super.get(ref)[pos] = auto_box(ref, value);
	}

	
	
	private Object auto_box(short ref, Object value) 
	{
		switch (arrayTypes.get(ref)) {
		case 10:
			return Integer.valueOf((short)value);
		case 11:
			return Float.valueOf((short)value);
		case 12:
			return Long.valueOf((short)value);
		case 13:
			return Double.valueOf((short)value);
		case 14:
			return Character.valueOf((char)(short)value);
		default: {
			System.err.println("Unkown data type error.");
			System.exit(201);
			return null;
			}		
		}
	}

	

	public short newArray(int type, int length) {
		if (length < 0) {
			System.err.println("Negative array size");
			System.exit(2);
		}

		Object[] newRef = null;

		switch (type) {
		case 10:
			newRef = new Integer[length];
			break; // CONST_INTEGER
		case 11:
			newRef = new Float[length];
			break; // CONST_FLOAT
		case 12:
			newRef = new Long[length];
			break; // CONST_LONG
		case 13:
			newRef = new Double[length];
			break; // CONST_DOUBLE
		case 14:
			newRef = new Character[length];
			break; // CONST_STRING
		default: {
			System.err.println("Unkown aray type");
			System.exit(3);
		}
		}
		
		super.put(++nextRef, newRef);
		arrayTypes.put(nextRef, type);
		return nextRef;
	}


}
