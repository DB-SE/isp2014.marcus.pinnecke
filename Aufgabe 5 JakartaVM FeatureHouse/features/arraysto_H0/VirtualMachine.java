/**
 * TODO description
 */
public class VirtualMachine {

	public void registerInstruction()
	{
		original();
		Arraysto op = new Arraysto();
		this.instructionSet.put(op.getByteCode(), op);
	}
}