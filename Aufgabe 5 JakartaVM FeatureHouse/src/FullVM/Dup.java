/**
 * Mnemonic:				castore
 * Opcode:					07		
 * Operand:					_
 * Stack (before->after):	value -> value, value	  
 * Description:				Duplicates the stacks top
 */
public  class  Dup  extends Instruction {
	

	public byte getByteCode() {
		return 0x07;
	}

	
	
	public void execute(short _, VirtualMachine context) {
		context.stack.push(context.stack.peek());
	}


}
