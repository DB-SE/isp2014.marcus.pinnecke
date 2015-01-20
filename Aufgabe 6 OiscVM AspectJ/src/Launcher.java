import java.util.ArrayList;
import java.util.List;


public class Launcher {

	public static void main(String[] args) {
		
		int aAddress = 0;
		int tempAddress = 1;
		int bAddress = 2;
		
		List<Instruction> program = new ArrayList<Instruction>();
		program.add(new Store(aAddress, 10));
		program.add(new Store(bAddress, 5));
		
		// mem[b] := mem[b] + mem[a]
		program.add(new Subleq(aAddress, tempAddress));
		program.add(new Subleq(tempAddress, bAddress));
		program.add(new Subleq(tempAddress, tempAddress));
		program.add(new Subleq(tempAddress, tempAddress));
		
		program.add(new Print());
		
		
		new OiscVM(program).run();
	}

}
