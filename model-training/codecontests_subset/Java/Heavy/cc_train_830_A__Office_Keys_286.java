
import java.util.*;
import java.io.*;

public class OfficeKeys {

	// https://codeforces.com/contest/830/problem/A
	
	public static void main(String[] args) throws IOException, FileNotFoundException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader in = new BufferedReader(new FileReader("OfficeKeys"));

		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		long p = Long.parseLong(st.nextToken());
		
		long[] a = new long[n];
		long[] b = new long[k];
		st = new StringTokenizer(in.readLine());
		for (int i=0; i<n; i++) a[i] = Long.parseLong(st.nextToken());
		st = new StringTokenizer(in.readLine());
		for (int i=0; i<k; i++) b[i] = Long.parseLong(st.nextToken());
		Arrays.parallelSort(a);
		Arrays.parallelSort(b);
		long min=0;
		long max = (long)(2e9+1000);
		while (min  <max) {
			long middle = (min + max)/2;
			if (check(middle, a, b, p)) {
				max = middle;
			}
			else min = middle+1;
		}
		System.out.println(min);
	}
	
	public static boolean check(long mid, long[] a, long[] b, long p) {
		int n = a.length;
		int m = b.length;
		int index=0;
		for (int i=0; i<n; i++) {
			while (index < m && Math.abs(b[index] - a[i]) + Math.abs(b[index] - p) > mid) index++;
			if (index >= m) return false;
			// used this
			index++;
		}
		return true;
	}
}