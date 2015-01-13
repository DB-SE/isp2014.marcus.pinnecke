/**
 * TODO description
 */
public class VirtualMachine {

	public void registerInstruction()
	{
		original();
		Dup op = new Dup();
		this.instructionSet.put(op.getByteCode(), op);
	}
}