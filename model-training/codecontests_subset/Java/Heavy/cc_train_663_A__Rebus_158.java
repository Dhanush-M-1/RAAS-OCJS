import java.io.*;
import java.util.*;
import java.math.*;

public class B {
	public static void main(String[] args) throws IOException {

		/**/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/b.in"))));
		/**/
		
		ArrayList<Character> cs = new ArrayList<Character>();
		int numP = 0;
		int numM = 0;
		int n = 0;
		sc.next();
		numP++;
		while (true) {
			String s = sc.next();
			if (s.equals("=")) {
				n = sc.nextInt();
				break;
			} else if (s.equals("+")) {
				numP++;
				cs.add(s.charAt(0));
				sc.next();
			} else if (s.equals("-")) {
				numM++;
				cs.add(s.charAt(0));
				sc.next();
			}
		}
		if (numP*n-numM < n || numP-numM*n > n) {
			System.out.println("Impossible");
			return;
		}
		System.out.println("Possible");
		int[] ps = new int[numP];
		int[] ms = new int[numM];
		
		if (numP - numM == n) {
			for (int i = 0; i < numP; i++)
				ps[i] = 1;
			for (int i = 0; i < numM; i++)
				ms[i] = 1;
		} else if (numP - numM < n) {
			for (int i = 0; i < numM; i++)
				ms[i] = 1;
			for (int i = 0; i < (n-(numP-numM))%numP; i++)
				ps[i] = 1;
			for (int i = 0; i < numP; i++)
				ps[i] += (n-(numP-numM))/numP+1;
		} else {
			for (int i = 0; i < numP; i++)
				ps[i] = 1;
			for (int i = 0; i < ((numP-numM)-n)%numM; i++)
				ms[i] = 1;
			for (int i = 0; i < numM; i++)
				ms[i] += ((numP-numM)-n)/numM+1;
		}
		System.out.print(ps[0]);
		int pi = 1;
		int mi = 0;
		for (char c : cs) {
			System.out.print(" "+c);
			if (c=='+') {
				System.out.print(" "+ps[pi++]);
			} else {
				System.out.print(" "+ms[mi++]);
			}
		}
		System.out.println(" = "+n);
	}
}