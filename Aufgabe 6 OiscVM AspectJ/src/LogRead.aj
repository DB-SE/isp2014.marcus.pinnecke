
public aspect LogRead {
	
	pointcut catchMemReadOperation(int index, int defaultValue): execution (int OiscVM.getMemAt(int,int)) && args(index, defaultValue); 
	
	before(int index, int defaultValue) : catchMemReadOperation(index, defaultValue) {
		System.out.println("MEM Read at " + index + ", default = " + defaultValue);
	}
	
}