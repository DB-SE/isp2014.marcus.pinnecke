
public aspect PPAfterExecution {

	pointcut catchTickOperation(): execution (void OiscVM.tick()); 
	
	after() : catchTickOperation() {
		OiscVM vm = ((OiscVM)thisJoinPoint.getTarget());
		if (vm.programCounter < vm.program.size()) {
			System.out.println("Print programm (after exec)");
			for (int i = 0; i< vm.program.size(); i++)
				System.out.println((vm.programCounter == i ? " (X) " : "  ") + "\t" + vm.program.get(i).print());
		}
	}
	
}