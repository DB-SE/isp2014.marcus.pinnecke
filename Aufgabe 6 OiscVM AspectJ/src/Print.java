import java.util.SortedSet;
import java.util.TreeSet;


public class Print implements Instruction {

	public void execute(OiscVM context) {
		SortedSet<Integer> set = new TreeSet<Integer>();
		set.addAll(context.getAllMemAddresses());
		for (int i = 0; i < set.size(); i++)
			System.out.println( i + ":\t" + context.getMemAt(i,0));
	}

	public String print() {
		return "PRINT";
	}

}
