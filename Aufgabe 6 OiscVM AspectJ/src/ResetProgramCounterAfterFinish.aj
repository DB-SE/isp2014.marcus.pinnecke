import apple.laf.JRSUIConstants.Size;


public aspect ResetProgramCounterAfterFinish {
	
	pointcut catchTickOperation(): execution (void OiscVM.tick()); 
	
	after() : catchTickOperation() {
		OiscVM vm = ((OiscVM)thisJoinPoint.getTarget());
		if (vm.programCounter >= vm.program.size())  {
			vm.programCounter = 0;
			System.out.println("Reset");
		}		
	}
	
}