/**
 * TODO description
 */
public class VirtualMachine {

	public void registerInstruction()
	{
		original();
		GetStatic op = new GetStatic();
		this.instructionSet.put(op.getByteCode(), op);
	}
}