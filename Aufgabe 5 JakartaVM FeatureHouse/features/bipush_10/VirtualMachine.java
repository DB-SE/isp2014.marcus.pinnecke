/**
 * TODO description
 */
public class VirtualMachine {

	public void registerInstruction()
	{
		original();
		Bipush op = new Bipush();
		this.instructionSet.put(op.getByteCode(), op);
	}
}