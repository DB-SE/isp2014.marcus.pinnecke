
public aspect LogWrite {
	
	pointcut catchMemReadOperation(int index, int value): execution (void OiscVM.setMemAt(int,int)) && args(index, value); 
	
	before(int index, int value) : catchMemReadOperation(index, value) {
		System.out.println("MEM Set at " + index + " = " + value);
	}
	
}