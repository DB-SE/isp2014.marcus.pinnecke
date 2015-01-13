/**
 * Mnemonic:				aaload
 * Opcode:					05
 * Operand:					-
 * Stack (before->after):	index, arrayref -> value	  
 * Description:				load onto the stack a reference from an array
 */
public class Aaload extends Instruction {

	public byte getByteCode() {
		return 0x05;
	}
	
	public void execute(short _, VirtualMachine context) {
		short index = context.stack.pop();
		short ref = context.stack.pop();
		
		Object o = context.arrayObjectsReferenceRegister.load(ref, index);
		context.stack.push(Short.valueOf(o.toString())); // TODO: This cast is a hack
	}
	
}