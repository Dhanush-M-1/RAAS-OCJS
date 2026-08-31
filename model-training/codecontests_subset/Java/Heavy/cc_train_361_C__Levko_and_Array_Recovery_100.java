import java.util.*;
public class ArrayRecov {
	public static void main (String [] arg) {
		Scanner sc = new Scanner(System.in);
		//while (sc.hasNextInt()) {
		int n = sc.nextInt();
		int m = sc.nextInt();
		int [] D = new int [n];
		
		int [] CON = new int [n];
		int [][] V = new int [m][4];
		
		Arrays.fill(CON, Integer.MAX_VALUE);
		
		
		int ptr = 0;
		
		boolean works = true;
		for (int i = 0; i<m; ++i) {
			int t = sc.nextInt();
			int L = sc.nextInt();
			int R = sc.nextInt();
			int dm = sc.nextInt();
			V[i][0] = L;
			V[i][1] = R;
			V[i][2] = dm;
			V[i][3] = t;
			
			if (t == 1) for (int j = L-1; j<R; ++j) D[j]+=dm;
			if (t == 2) {
				for (int j = L-1 ;j<R; ++j) {
					int cons = dm - D[j];
					
					//Replace constraint.
					if (CON[j] > cons) CON[j] = cons;
				}
				ptr++;
			}
		}
		Arrays.fill(D, 0);
		for (int i =0; i<m; ++i) {
			int L = V[i][0];
			int R = V[i][1];
			int dm = V[i][2];
			if (V[i][3] == 1) {
				for (int j = L-1; j<R; ++j) D[j]+=dm;
				continue;
			}
			boolean found = false;
			for (int j = L-1 ;j<R; ++j) {
				int cons = dm - D[j];
				//Replace constraint.
				if (CON[j] == cons) found = true;
			}
			if (!found) works = false;
		}
		
		
		if (!works) { System.out.println("NO"); return;}
		
		System.out.println("YES");
	
		
		StringBuilder b = new StringBuilder(D.length*10);
		for (int i = 0; i<D.length; ++i) { 
			if (i != 0) b = b.append(' ');
			b = b.append((CON[i] == Integer.MAX_VALUE) ? 0 : CON[i]);
		}
		System.out.println(b);
		
	
		//}
	}
}