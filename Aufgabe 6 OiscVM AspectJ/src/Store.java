
public class Store implements Instruction {
	
	private int address;
	private int value;
	
	public Store(int address, int value) {
		this.address = address;
		this.value = value;
	}

	public void execute(OiscVM context) {
		context.setMemAt(this.address, this.value);	
	}

	public String print() {
		return "STORE " + this.address + ", " + this.value;
	}

}
