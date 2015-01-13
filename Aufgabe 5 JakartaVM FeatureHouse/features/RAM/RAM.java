/**
 * TODO description
 */
public class RAM {
	
	private byte[] content = new byte[64*1024];
	
	public void set(int address, byte content) {
		if (address > this.content.length - 1) {
			System.err.println("Out of VM memory");
			System.exit(5);
		}
		this.content[address] = content;
	}
	
	public byte get(int address) {
		if (address > this.content.length - 1) {
			System.err.println("Access out of VM memory");
			System.exit(6);
		} else if (address < 0) {
			System.err.println("Illegal VM memory address");
			System.exit(7);
		}
		
		return this.content[address];
	}

}