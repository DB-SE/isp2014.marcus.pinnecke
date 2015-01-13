/**
 * TODO description
 */
public class VirtualMachine {

	public void registerInstruction()
	{
		original();
		Castore op = new Castore();
		this.instructionSet.put(op.getByteCode(), op);
	}
}