/**
 * Mnemonic:				getstatic (only type level)
 * Opcode:					03
 * Operand:					index
 * Stack (before->after):	_ -> value	  
 * Description:				Gets the value of constant object with id index
 */
public  class  GetStatic  extends Instruction {
	

	public byte getByteCode() {
		return 0x03;
	}

	
	
	public void execute(short index, VirtualMachine context) {
		short typeIndex = context.constantPool.get(index);
		
		 if ((typeIndex == 10 ) || // Int
		     (typeIndex == 11 ) || // Float
			 (typeIndex == 12 ) || // Long
			 (typeIndex == 13 ) || // Double
			 (typeIndex == 14 )) { // Char
			 
			 context.stack.push(typeIndex);
			 
		 } else {
			 System.err.println("Unknown or illegal type index from constant pool at level types.");
			 System.exit(9);
		 }
	}


}
