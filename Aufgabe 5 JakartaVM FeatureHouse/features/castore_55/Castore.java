/**
 * Mnemonic:				castore
 * Opcode:					04		
 * Operand:					-
 * Stack (before->after):	index, value, arrayref -> _	  
 * Description:				Stores value at array arrayred at position index
 */
public class Castore extends Instruction {

	public byte getByteCode() {
		return 0x04;
	}
	
	public void execute(short _, VirtualMachine context) {
		short index = context.stack.pop();
		short value = context.stack.pop();
		short arrayref = context.stack.pop();
		context.arrayObjectsReferenceRegister.store(arrayref, index, value);
	}
	
}