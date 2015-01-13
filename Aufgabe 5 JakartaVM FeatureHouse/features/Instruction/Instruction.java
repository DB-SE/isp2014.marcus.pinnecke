/**
 * TODO description
 */
public abstract class Instruction {

	public abstract byte getByteCode();
	
	public abstract void execute(short operand, VirtualMachine context);
}