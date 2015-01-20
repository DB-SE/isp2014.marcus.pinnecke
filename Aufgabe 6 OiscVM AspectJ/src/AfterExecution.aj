
public aspect AfterExecution {
	
	pointcut catchTickOperation(): execution (void OiscVM.tick()); 
		
	after() : catchTickOperation() {
		OiscVM vm = ((OiscVM)thisJoinPoint.getTarget());
		if (vm.programCounter < vm.program.size() && vm.programCounter > 1)
			System.out.println("Instruction was executed " + vm.program.get(vm.programCounter-1).print());
	}
	
}