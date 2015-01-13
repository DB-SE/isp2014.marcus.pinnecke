/**
 * Mnemonic:				newarray
 * Opcode:					00
 * Operand:					index
 * Stack (before->after):	count -> reference	  
 * Description:				create a new array of references of length *count* and component 
 * 							type identified by the class reference *index*
 */
public  class  NewArray  extends Instruction {
	

	public byte getByteCode() {
		return 0x00;
	}

	
	
	public void execute(short typeIndex, VirtualMachine context) {
		short size = context.stack.pop();
		
		short typeValue = context.constantPool.get(typeIndex);
		short newref = context.arrayObjectsReferenceRegister.newArray(typeValue, size);
				
		context.stack.push(newref);		
	}


}
