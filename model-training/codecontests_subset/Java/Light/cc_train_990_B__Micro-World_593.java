import java.util.*;
import java.math.*;
import java.io.*;

public class CF990B {
	public CF990B() {
		FS scan = new FS();
		int n = scan.nextInt(), k = scan.nextInt();
		int[] a = new int[n];
		for(int i = 0 ; i < n ; i++)
			a[i] = scan.nextInt();
		TreeSet<Integer> set = new TreeSet<>();
		for(int i = 0 ; i < n ; i++)
			set.add(a[i]);
		int res = n;
		for(int i = 0 ; i < n ; i++) {
			if(set.floor(a[i] + k) != null && set.floor(a[i] + k) != a[i])
				res--;
		}
		System.out.println(res);
	}
	class FS {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		public String next() {
			while(!st.hasMoreTokens()) {
				try { st = new StringTokenizer(br.readLine()); }
				catch(Exception e) { e.printStackTrace(); }
			}
			return st.nextToken();
		}
		public int nextInt() { return Integer.parseInt(next()); }
	}
	public static void main(String[] args) { new CF990B(); }
}
