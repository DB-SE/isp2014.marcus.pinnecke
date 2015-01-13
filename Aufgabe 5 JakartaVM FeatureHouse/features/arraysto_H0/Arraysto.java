/**
 * Mnemonic:				arraysto
 * Opcode:					02
 * Operand:					address
 * Stack (before->after):	reference -> _	  
 * Description:				Writes entire content of array reference to memory at address
 */
public class Arraysto extends Instruction {

	public byte getByteCode() {
		return 0x02;
	}
	
	public void execute(short address, VirtualMachine context) {
		short ref = context.stack.pop();
		Object[] array = context.arrayObjectsReferenceRegister.get(ref);
		
		if (array.length == 0)
			return;
		else {
			if (array[0] instanceof Integer)
				arraystoInt(address, array, context);
			else if (array[0] instanceof Float)
				arraystoFloat(address, array, context);
			else if (array[0] instanceof Long)
				arraystoLong(address, array, context);
			else if (array[0] instanceof Double)
				arraystoDouble(address, array, context);
			else if (array[0] instanceof Character)
				arraystoCharacter(address, array, context);
			else {
				System.err.println("Unkown type of array.");
				System.exit(4);
			}
		}
	}
	
	private void arraystoInt(short address, Object[] array, VirtualMachine context) {
		for (int i = 0; i < array.length && array[i] != null; i++) {
			byte b4 = (byte) ((int)array[i] & 0xF);
			byte b3 = (byte) (((int)array[i] >> 2) & 0xF);
			byte b2 = (byte) (((int)array[i] >> 4) & 0xF);
			byte b1 = (byte) (((int)array[i] >> 8) & 0xF);
			context.ram.set(i + address++, b1);
			context.ram.set(i + address++, b2);
			context.ram.set(i + address++, b3);
			context.ram.set(i + address++, b4);
		}
	}
	
	private void arraystoFloat(short address, Object[] array, VirtualMachine context) {
		System.err.println("Unsupported operation. Not implemented");
		System.exit(8);
	}
	
	private void arraystoLong(short address, Object[] array, VirtualMachine context) {
		System.err.println("Unsupported operation. Not implemented");
		System.exit(9);
	}
	
	private void arraystoDouble(short address, Object[] array, VirtualMachine context) {
		System.err.println("Unsupported operation. Not implemented");
		System.exit(10);
	}
	
	private void arraystoCharacter(short address, Object[] array, VirtualMachine context) {
		for (int i = 0; i < array.length; i++) { 		
			byte b1 = (byte) (((char)(array[i]) & 0x1100) >>> 2);
			byte b2 = (byte) (((char)(array[i]) & 0x0011));
			context.ram.set(i + address++, b1);
			context.ram.set(i + address++, b2);
		}
	}
	
}