
public aspect LogProgramCounterBeforeExecitopm {
	
	pointcut catchTickOperation(): execution (void OiscVM.tick()); 
	
	before() : catchTickOperation() {
		OiscVM vm = ((OiscVM)thisJoinPoint.getTarget());
		System.out.println("ProgramCounter before execution: " + vm.programCounter);
	}
}