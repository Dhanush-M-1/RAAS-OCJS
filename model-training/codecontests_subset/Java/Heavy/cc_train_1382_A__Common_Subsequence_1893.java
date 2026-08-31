import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;
import java.util.Map.Entry;

public class A {

	public static void main(String[] args) {
		FastScanner fs = new FastScanner();
		int t =fs.nextInt();
		test:while(t-->0) {
		int n=fs.nextInt();
		int m=fs.nextInt();
		int a[]=fs.readArray(n);
		int b[] = fs.readArray(m);
		HashSet<Integer> map = new HashSet<>();
		for(int i=0;i<n;i++) {
			map.add(a[i]);
		}
		for(int i=0;i<m;i++) {
			if(map.contains(b[i])) {
				System.out.println("YES");
			 	System.out.println("1"+" "+b[i]);
			    continue test;	
			}
		}
		System.out.println("NO");
			
		}
		}
	
	
	static void sort(int[] a ) {
		ArrayList<Integer> l = new ArrayList<>();
		for(int i:a) l.add(i);
		Collections.sort(l);
		for(int i=0;i<l.size();i++) a[i]=l.get(i);
	}
	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		String next() {
			while(!st.hasMoreTokens())
				try {
					st = new StringTokenizer(br.readLine());
				}catch(IOException e) {
					e.printStackTrace();
				}
			return st.nextToken();
		}
		int nextInt() {
			return Integer.parseInt(next());
		}
		int[] readArray(int n) {
			int[] a = new int[n];
			for(int i=0;i<n;i++)a[i]=nextInt();
			return a;
		}
		long nextLong() {
			return Long.parseLong(next());
		}
	}

}
