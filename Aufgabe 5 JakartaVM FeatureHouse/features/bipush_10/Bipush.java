/**
 * Mnemonic:				bipush
 * Opcode:					01
 * Operand:					value
 * Stack (before->after):	_ -> value	  
 * Description:				pushes value as integer into stack
 */
public class Bipush extends Instruction {

	public byte getByteCode() {
		return 0x01;
	}
	
	public void execute(short operand, VirtualMachine context) {
		context.stack.push(operand);
	}
	
}