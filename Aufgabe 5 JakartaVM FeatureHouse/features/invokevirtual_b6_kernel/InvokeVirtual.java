/**
 * Mnemonic:				invokevirtual (kernel level)
 * Opcode:					06
 * Operand:					_
 * Stack (before->after):	constID, ArgCount, [a1,...,a_ArgCount] 
 * Description:				invokes a methode constID from constant pool with ArgCount arguments. The return value is pushed to stack
 */
public class InvokeVirtual extends Instruction {

	public byte getByteCode() {
		return 0x06;
	}
	
	public void execute(short _, VirtualMachine context) {
		short constID = context.stack.pop();
		short methodID = context.constantPool.get(constID);
		
		
		
		if (methodID != 6661 && methodID != 6662 && methodID != 6663) // Sandbox write, System exit, System write
		{
			System.err.println("Unknown invoke on " + methodID);
			System.exit(14);
		}
		
		short argCount = context.stack.pop();		
		short[] args = new short[argCount];
		
		System.err.println("ConsIS" + constID);
		System.err.println("argCount" + argCount);
		
		for (int i = 0; i < args.length; i++) {
			args[i] = context.stack.pop();
		}
		
		
		
		switch (methodID) {
		case 6661: invokeSandboxWrite(args, context); break;
		case 6662: invokeSystemExit(args); break;
		case 6663: invokeSystemWrite(args, context); break;
		}
	}
	
	private void invokeSandboxWrite(short[] args, VirtualMachine context) {
		if (args.length == 0) {
			return;
		}
		
		for (int i = 0; i < args.length; i++) {
			System.out.print( (char)(args[i]));
		}
	}
	
	private void invokeSystemExit(short[] args) {
		if (args.length < 1) {
			System.err.println("SYS_EXIT requires exact one arg");
			System.exit(15);
		}
		
		System.err.println("\n\n\n** KERNEL CALL **\nSystem exit.");
		System.exit(args[0]);
	}

	private void invokeSystemWrite(short[] args, VirtualMachine context) {
		if (args.length == 0) {
			System.err.println("SYS_WRITE requires exact two arg");
			System.exit(15);
		}
		
		System.err.print("\n\n\n** KERNEL CALL Write **\n> ");
		
		short address = args[0];
		short length = args[1];
		
		for (int i = 0; i < length; i++) {
			System.err.print((char)context.ram.get(address + i));
		}
	}
}