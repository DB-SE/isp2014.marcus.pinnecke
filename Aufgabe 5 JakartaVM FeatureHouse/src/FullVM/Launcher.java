/**
 * TODO description
 */
public  class  Launcher {
	
	

	public static void main(String[] args) {
		VirtualMachine vm = new VirtualMachine();
		
		//byte[] program = ProgramExamples.PROG_HELLO_WORLD_STACK;
		//byte[] program = ProgramExamples.PROG_HELLO_WORLD_ARRAY_REF;
		//byte[] program = ProgramExamples.PROG_ACCESS_CONSTANT_POOL_TYPES;
		//byte[] program = ProgramExamples.PROG_ACCESS_CONSTANT_POOL_SANDBOX_METHODS;
		byte[] program = ProgramExamples.PROG_RAM_MANIPULATION;
		
		vm.load(0x00, program);		
		
		for (int i = 0; i < program.length / 3; i++)
			vm.tick();
		
		System.out.println("\n** END **");
		
	}


}
