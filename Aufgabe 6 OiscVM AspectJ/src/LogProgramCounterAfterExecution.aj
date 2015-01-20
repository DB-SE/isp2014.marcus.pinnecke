
public aspect LogProgramCounterAfterExecution {
	
	pointcut catchTickOperation(): execution (void OiscVM.tick()); 
	
	after() : catchTickOperation() {
		OiscVM vm = ((OiscVM)thisJoinPoint.getTarget());
		System.out.println("ProgramCounter after execution: " + vm.programCounter);
	}
	
}