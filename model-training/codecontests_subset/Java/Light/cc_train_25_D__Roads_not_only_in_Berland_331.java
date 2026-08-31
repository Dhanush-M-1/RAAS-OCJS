/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Codechef
{
    static int p[];
	static ArrayList<Integer> del;
 
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
 
		int n = Integer.parseInt(in.readLine());
		p = new int[n];
		for (int i = 0; i < p.length; i++) {
			p[i] = i;
		}
 
		del = new ArrayList<Integer>();
 
		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			union(a, b);
		}
 
		System.out.println(del.size() / 2);
		for (int k = 0; k < del.size(); k += 2) {
			int i = del.get(k);
			int j = del.get(k + 1);
			int u = parent(i);
			int v = -1;
			for (int l = 0; l < n; l++) {
				if (parent(l) != u) {
					v = l;
					break;
				}
			}
			union(u, v);
			System.out.printf("%d %d %d %d\n", i + 1, j + 1, u + 1, v + 1);
		}
 
	}
 
	static void union(int i, int j) {
		int pi = parent(i);
		int pj = parent(j);
 
		if (pi == pj) {
			del.add(i);
			del.add(j);
		} else {
			p[pi] = pj;
		}
	}
 
	static int parent(int i) {
		if (p[i] != i) {
			p[i] = parent(p[i]);
			return p[i];
		}
		return i;
	}
}
