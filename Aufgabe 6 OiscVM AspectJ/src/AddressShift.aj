
public aspect AddressShift {
	
	public static int OFFSET = 666;
	
	pointcut catchMemReadOperation(int index, int defaultValue): execution (int OiscVM.getMemAt(int,int)) && args(index, defaultValue); 
	pointcut catchMemWriteOperation(int index, int value): execution (void OiscVM.setMemAt(int,int)) && args(index, value);
	
	int around(int index, int defaultValue) : catchMemReadOperation(index, defaultValue) {
		
		try {
			System.out.println("READ MEM address shift " + index + " to " + (index + OFFSET));
			return proceed(index + 666, defaultValue);
			} finally {
				
			}
		
	}
	
	void around(int index, int value) : catchMemWriteOperation(index, value) {
		
		try {
			System.out.println("Write MEM address shift " + index + " to " + (index + OFFSET));
			proceed(index + 666, value);
			} finally {
				
			}
		
	}
	
}