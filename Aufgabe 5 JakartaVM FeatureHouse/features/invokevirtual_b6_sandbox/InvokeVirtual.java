/**
 * Mnemonic:				invokevirtual (sandbox level)
 * Opcode:					06
 * Operand:					_
 * Stack (before->after):	constID, ArgCount, [a1,...,a_ArgCount] 
 * Description:				invokes a methode constID from constant pool with ArgCount arguments. The return value is pushed to stack
 */
public class InvokeVirtual extends Instruction {

//	public byte getByteCode() {
//		return 0x06;
//	}
//	
//	public void execute(short _, VirtualMachine context) {
//		short constID = context.stack.pop();
//		short methodID = context.constantPool.get(constID);
//		
//		if (methodID != 6661) // Sandbox write
//		{
//			System.err.println("Unknown or illegal invoke on " + constID);
//			System.exit(13);
//		}
//		
//		short argCount = context.stack.pop();
//		if (argCount == 0)
//			return;
//		
//		for (int i = 0; i < argCount; i++) {
//			System.out.print( (char) ((short) context.stack.pop()));
//			System.out.flush();
//		}
//	}
//	
	
	public byte getByteCode() {
		return 0x06;
	}
	
	public void execute(short _, VirtualMachine context) {
		short constID = context.stack.pop();
		short methodID = context.constantPool.get(constID);
		
		if (methodID != 6661) // Sandbox write
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
	
}