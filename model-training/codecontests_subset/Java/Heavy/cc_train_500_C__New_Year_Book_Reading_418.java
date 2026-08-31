import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int m = s.nextInt(), n = s.nextInt();
		int[] w = new int[m];
		for (int i = 0; i < m; i++) {
			w[i] = s.nextInt();
		}
		int[] a = new int[m];
		int length = 0, ans = 0;
		for (int i = 0; i < n; i++) {
			int b = s.nextInt() - 1;
			for (int j = 0; j <= length; j++) {
				if (j == length || a[j] == b) {
					for (int k = j; k >= 1; k--) {
						a[k] = a[k - 1];
					}
					a[0] = b;
					if (j == length) {
						length++;
					}
					break;
				}
				ans += w[a[j]];
			}
		}
		System.out.println(ans);
	}
}
