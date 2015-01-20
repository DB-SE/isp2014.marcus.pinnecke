/**
 * TODO description
 */
public  class  Stack  extends java.util.LinkedList<Short> {
	
	
	@Override
	public void push(Short e) {
		super.push(e);
		
		printit();
	}

	
	
	@Override
	public Short pop() {
		printit();
		
		if (isEmpty()) {
			System.err.println("Stack underflow.");
			System.exit(1);
		}
		return super.pop();
	}

	
	
	private void printit() {
		String s = "|";
		for (int i = 0; i < super.size(); i++)
			s += super.get(i) + "|";
		System.out.println(s);
	}


}
