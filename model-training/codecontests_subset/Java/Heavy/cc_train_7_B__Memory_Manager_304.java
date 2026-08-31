import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;

public class B {
	private static StreamTokenizer in;
	private static PrintWriter out;
	private static int nextInt(){
		try {
			in.nextToken();
		} catch (Exception e) {}
		return (int)(in.nval);
	}
	private static String nextString() {
		try {
			in.nextToken();
		} catch (Exception e) {}
		return in.sval;
	}
	public static void main(String[] args) {
		in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		out = new PrintWriter(System.out);
		
		int t = nextInt(), m = nextInt(), p = 1, M = 100500;
		int[][] a = new int[m][2];
		for (int i=0;i<m;i++) {
			a[i][0] = 0;
			a[i][1] = M;
		}
			
		for (; t>0; t--) {
			int ast = 999, l = 1;
			for (int i=0;i<m;i++) {
				if (a[i][0] == 0) {
					a[i][1] = 100500;
					continue;
				}
				if (a[i][1] == ast) {
					a[i][1] = l;
				}
				else {
					ast = a[i][1];
				}
			}
			
			String query = nextString();
			int c = 0;
			
			if (query.equals("alloc") || query.equals("erase"))
				c = nextInt();
				
			if (query.equals("alloc")) {
				int n = 0, coll = 0, last = 999, i = 0;
				for (i=0;i<m;i++) {
					if (n == c) break;
					if (a[i][0] != 0) {
						if (a[i][0] != last) {
							coll++;
							last = a[i][0];
							n = 0;
						}
					}
					else {
						n++;
					}
				}
				if (n != c) {
					out.println("NULL");
					continue;
				}
				i--;
				for (int e = 0; e<n; e++, i--) {
					a[i][0] = p;
					a[i][1] = coll;
				}
				out.println(p++);
			}
			
			if (query.equals("erase")) {
				if (c==0) {
					out.println("ILLEGAL_ERASE_ARGUMENT");
					continue;
				}
				boolean u = false;
				for (int i=0;i<m;i++) {
					if (a[i][0] == c) {
						a[i][0] = 0;
						a[i][1] = M;
						u = true;
					}
				}
				if (!u) out.println("ILLEGAL_ERASE_ARGUMENT");
			}
			
			if (query.equals("defragment")) {
				Arrays.sort(a, new Comparator<int[]>() {
					public int compare(int[] a,int[] b) {
						return a[1] > b[1] ? 1 : a[1] == b[1] ? 0 : -1;
					}
				});
			}
			
			
			
		}
		
		out.flush();
	}
}
