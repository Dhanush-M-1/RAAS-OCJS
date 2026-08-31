import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ex2 {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n, k;
		int counter = 0;
		int old;
		int counterOld = 1;
		ArrayList<Integer> a;
		
		n = in.nextInt();
		k = in.nextInt();
		a = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			a.add(in.nextInt());
 		}
		
		Collections.sort(a);
		old = a.get(0);
		for ( int i = 1; i < a.size(); i ++) {
			if (a.get(i) == old) {
				counterOld++;
				continue;
			}
			if (a.get(i) <= a.get(i-1) + k) {
				counter += counterOld;
			}
			old = a.get(i);
			counterOld = 1;
		}	
		System.out.println(n-counter);
	}
}
