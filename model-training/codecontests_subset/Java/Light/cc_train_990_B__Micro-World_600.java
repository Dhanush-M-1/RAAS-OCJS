import java.util.TreeMap;
import java.util.Scanner;

public class MicroWorld {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		TreeMap<Integer,Integer> bacteria = new TreeMap<Integer,Integer>();
		int size = 0;
		
		int n = in.nextInt();
		int K = in.nextInt();
		int min = 10000000;
		
		for (int i = 0; i < n; i++) {
			int a = in.nextInt();
			if (bacteria.get(a) != null) {
				int f = bacteria.get(a);
				bacteria.remove(a);
				bacteria.put(a, f+1);
			}
			else {
				bacteria.put(a, 1);
				if (a < min) {
					min = a;
				}
			}
		}
		
		//remove min from bacteria but store how many there were
		int y = bacteria.get(min);
		int x = bacteria.get(min);
		bacteria.remove(min);
		
		while(bacteria.ceilingKey(min) != null) {
			// if min can't be removed, then add amount of mins to size
			int bigger = bacteria.ceilingKey(min);

			y = bacteria.get(bigger);
			
			if(min + K < bigger) {
				size = size + x;
			}

			min = bigger;
			x = bacteria.get(min);
			bacteria.remove(min);
		}
		
		System.out.println(size+y);
		
	}

}
