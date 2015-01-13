/**
 * TODO description
 */
public class VirtualMachine {

	public void registerInstruction()
	{
		original();
		InvokeVirtual op = new InvokeVirtual();
		this.instructionSet.put(op.getByteCode(), op);
	}
}