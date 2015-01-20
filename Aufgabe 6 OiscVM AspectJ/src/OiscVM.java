import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class OiscVM {

	List<Instruction> program = new ArrayList<Instruction>();	
	private Map<Integer, Integer> mem = new HashMap<Integer, Integer>();	
	int programCounter;
	
	public int getMemAt(int index, int defaultValue) {
		if (!mem.containsKey(index))
			return defaultValue;
		else return mem.get(index);
	}
	
	public void setMemAt(int index, int value) {
		mem.put(index, value);
	}
	
	public Set<Integer> getAllMemAddresses() {
		return mem.keySet();
	}
	
	public OiscVM(List<Instruction> program) {
		this.load(program);
	}
	
	public void load(List<Instruction> program) {
		this.program = program;
		this.programCounter = 0;
	}
	
	private void tick() {
		this.program.get(this.programCounter++).execute(this);
		if (this.programCounter > this.program.size())
			throw new RuntimeException ("Program-Counter out of bounds");
	}
	
	public void run() {
		for (; this.programCounter < this.program.size() ;)
			this.tick();
	}
	
	
}
