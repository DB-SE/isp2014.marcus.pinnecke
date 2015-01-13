/**
 * TODO description
 */
public   class  VirtualMachine {
	

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

	
	
	 private void  registerInstruction__wrappee__VirtualMachine  ()
	{
		
	}

	

	 private void  registerInstruction__wrappee__newarray_c5  ()
	{
		registerInstruction__wrappee__VirtualMachine();
		NewArray op = new NewArray();
		this.instructionSet.put(op.getByteCode(), op);
	}

	

	 private void  registerInstruction__wrappee__bipush_10  ()
	{
		registerInstruction__wrappee__newarray_c5();
		Bipush op = new Bipush();
		this.instructionSet.put(op.getByteCode(), op);
	}

	

	 private void  registerInstruction__wrappee__arraysto_H0  ()
	{
		registerInstruction__wrappee__bipush_10();
		Arraysto op = new Arraysto();
		this.instructionSet.put(op.getByteCode(), op);
	}

	

	 private void  registerInstruction__wrappee__getstatic_b2_kernel  ()
	{
		registerInstruction__wrappee__arraysto_H0();
		GetStatic op = new GetStatic();
		this.instructionSet.put(op.getByteCode(), op);
	}

	

	 private void  registerInstruction__wrappee__castore_55  ()
	{
		registerInstruction__wrappee__getstatic_b2_kernel();
		Castore op = new Castore();
		this.instructionSet.put(op.getByteCode(), op);
	}

	

	 private void  registerInstruction__wrappee__aaload_32  ()
	{
		registerInstruction__wrappee__castore_55();
		Aaload op = new Aaload();
		this.instructionSet.put(op.getByteCode(), op);
	}

	

	 private void  registerInstruction__wrappee__invokevirtual_b6_kernel  ()
	{
		registerInstruction__wrappee__aaload_32();
		InvokeVirtual op = new InvokeVirtual();
		this.instructionSet.put(op.getByteCode(), op);
	}

	

	public void registerInstruction()
	{
		registerInstruction__wrappee__invokevirtual_b6_kernel();
		Dup op = new Dup();
		this.instructionSet.put(op.getByteCode(), op);
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

	

	ConstantPool constantPool = new ConstantPool();

	

	ArrayObjectsReferenceRegister arrayObjectsReferenceRegister = new ArrayObjectsReferenceRegister();


}
