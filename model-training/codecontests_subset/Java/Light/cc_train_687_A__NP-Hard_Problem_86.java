import java.io.*;
import java.util.*;

public class C {
	
	static int[] v;
	static int[] c = new int[2];
	static ArrayList<ArrayList<Integer>> a;	

	static boolean solve(int s) {
		int w = v[s];
		int q = 3 - w;
		boolean b = true;;
		for (Integer i : a.get(s)) {
			if (v[i] == w) {
				b = false;
				break;
			} else if (v[i] == 0) {
				v[i] = q;
				c[q-1]++;
				b = solve(i);
				if (!b) break;
			}
		}
		return b;
	}

	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		v = new int[n+1];
		a = new ArrayList<ArrayList<Integer>>(n+1); 
		for (int i = 0; i <= n; i++) {
			a.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			a.get(x).add(y);
			a.get(y).add(x);
		}
		boolean ok = true;
		for (int i = 0; i < n; i++) {
			if (v[i] == 0 && a.get(i).size() > 0) {
				v[i] = 1;
				c[0]++;
				ok = solve(i);
				if (!ok) break;
			}
		}
		if (ok) {
			out.println(c[0]);
			for (int i = 0; i <= n; i++) {
				if (v[i] == 1) {
					out.print(i+" ");
				}
			}
			out.println("");
			out.println(c[1]);
			for (int i = 0; i <= n; i++) {
				if (v[i] == 2) {
					out.print(i+" ");
				}
			}
			out.println("");
		} else {
			out.println("-1");
		}		
		out.close();
		sc.close();
	}
}