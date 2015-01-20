
public aspect PPBeforeExecution {
	
	pointcut catchTickOperation(): execution (void OiscVM.tick()); 
	
	before() : catchTickOperation() {
		OiscVM vm = ((OiscVM)thisJoinPoint.getTarget());
		if (vm.programCounter < vm.program.size() && vm.programCounter > 0) {
			System.out.println("Print programm (before exec)");
			for (int i = 0; i< vm.program.size(); i++)
				System.out.println((vm.programCounter == i ? " (X) " : "  ") + "\t" + vm.program.get(i).print());
		}
	}
	
}