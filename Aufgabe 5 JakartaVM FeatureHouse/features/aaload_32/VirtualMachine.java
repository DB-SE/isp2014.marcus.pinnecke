/**
 * TODO description
 */
public class VirtualMachine {

	public void registerInstruction()
	{
		original();
		Aaload op = new Aaload();
		this.instructionSet.put(op.getByteCode(), op);
	}
}