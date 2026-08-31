import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		solution s = new solution();
		s.solve();
		s.close();
	}
}

interface IO {
	Scanner in = new Scanner(new BufferedInputStream(System.in));
	PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
}

class solution implements IO {

	final int maxn = (int) 3e5 + 5;
	int[] a = new int[maxn];

	boolean check(int n) {
		int i, j;
		int l = -1, r = n;
		for(i = 0; i < n; i++){
			if(a[i] < i) break;
			l = i;
		}
		for(j = n - 1; j >= 0; j--){
			if(a[j] < n - j - 1) break;
			r = j;
		}
		if(r <= l) return true;
		return false;
	}

	void solve() {
		int t = in.nextInt();
		while (t-- != 0) {
			int n = in.nextInt();
			for (int i = 0; i < n; i++)
				a[i] = in.nextInt();
			
			int i, j;
			int l = -1, r = n;
			for(i = 0; i < n; i++){
				if(a[i] < i) break;
				l = i;
			}
			for(j = n - 1; j >= 0; j--){
				if(a[j] < n - j - 1) break;
				r = j;
			}
			out.println(r <= l ? "Yes" : "No");
		}
	}

	/*
	 * 4 1 3 2 1 3 1 1 2 9 0 1 1
	 */
	void close() {
		in.close();
		out.close();
	}
}
