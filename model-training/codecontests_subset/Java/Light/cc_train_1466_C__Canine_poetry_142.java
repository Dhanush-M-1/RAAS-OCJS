import java.util.*;
import java.io.*;

public class Q3 {
	private static final Scanner sc = new Scanner(System.in);
	public static void solve() {
		String s = sc.next();
		StringBuilder str = new StringBuilder(s);
		int l = s.length();
		if (l == 1) {
			System.out.println(0);
			return;
		}
		if (l == 2) {
			if (s.charAt(0) != s.charAt(1))
				System.out.println(0);
			else
				System.out.println(1);
			return;
		}
		int[] h = new int[l];
		if (s.charAt(1) == s.charAt(0)) {
			h[1] = 1;
			str.setCharAt(1, '$');
		}
		for (int i = 2; i < l; ++i) {
			if (str.charAt(i) == str.charAt(i - 1) && str.charAt(i - 1) != '$') {
				str.setCharAt(i, '$');
				h[i] = h[i - 1] + 1;
			}
			else if (str.charAt(i) == str.charAt(i - 2) && str.charAt(i - 2) != '$') {
				str.setCharAt(i, '$');
				h[i] = h[i - 1] + 1;
			}
			else {
				h[i] = h[i - 1];
			}
		}
		System.out.println(h[l - 1]);
	}
	public static void main(String[] args) {
		int t = sc.nextInt();
		for (int i = 0; i < t; ++i)
			solve();
	}
}