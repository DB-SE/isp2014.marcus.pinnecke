/**
 * TODO description
 */
public class VirtualMachine {

	RAM ram;
	Stack stack;
	
	private int programCounter;
	private InstructionSet instructionSet;
	
	public VirtualMachine() {
		this.ram = new RAM();
		this.stack = new Stack();
		this.instructionSet = new InstructionSet();
		registerInstruction();
	}
	
	public void registerInstruction()
	{
		
	}
	
	public void load(int address, byte[] program) {
		for (int i = 0; i < program.length; i++)
			this.ram.set(address + i, program[i]);
	}
	
	public void setProgramCounter(int address) {
		this.programCounter = address;
	}
	
	public void tick() {
		byte opcode = ram.get(programCounter++);
		byte operandL = ram.get(programCounter++);
		byte operandH = ram.get(programCounter++);
		short operand = operandL;
		operand = (short) (operand << 8);
		operand |= operandH;
		
		System.out.println("TICK " + opcode + " " + operand);
		
		checkOpcode(opcode);
		
		instructionSet.get(opcode).execute(operand, this);
				
		}	
	
	private void checkOpcode(byte opcode) {
		if (!instructionSet.containsKey(opcode)) {
			System.err.println("Opcode unknown: " + opcode);
			System.exit(200);
		}
	}
}