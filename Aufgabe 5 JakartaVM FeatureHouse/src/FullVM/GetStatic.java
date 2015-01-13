/**
 * Mnemonic:				getstatic (full access level)
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
		     (typeIndex == 11 ) || // Long
			 (typeIndex == 12 ) || // Float
			 (typeIndex == 13 ) || // Double
			 (typeIndex == 14 ) || // Char 
			 (typeIndex == 6661) || // Sandbox method call
			 (typeIndex == 6662) || // System exit
			 (typeIndex == 6663)) // System write 
		 {			 	 
			 
			 context.stack.push(typeIndex);
			 
		 } else {
			 System.err.println("Unknown or illegal type index from constant pool at level type/sandbox/kernel.");
			 System.exit(10);
		 }
	}


}
