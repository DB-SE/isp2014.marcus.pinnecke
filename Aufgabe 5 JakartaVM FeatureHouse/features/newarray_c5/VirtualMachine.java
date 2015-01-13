/**
 * TODO description
 */
public class VirtualMachine {

	public void registerInstruction()
	{
		original();
		NewArray op = new NewArray();
		this.instructionSet.put(op.getByteCode(), op);
	}
}