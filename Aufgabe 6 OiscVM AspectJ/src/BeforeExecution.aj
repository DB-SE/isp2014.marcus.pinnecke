
public aspect BeforeExecution {
	
	pointcut catchTickOperation(): execution (void OiscVM.tick()); 
	
	before() : catchTickOperation() {
		OiscVM vm = ((OiscVM)thisJoinPoint.getTarget());
		System.out.println("Instruction to be executed " + vm.program.get(vm.programCounter).print());
	}
}