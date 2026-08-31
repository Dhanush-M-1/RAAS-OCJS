

import java.util.Arrays;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		while (t-- > 0) {
			int n = input.nextInt();
			String a, b, c, d;
			a = input.next();
			b = input.next();
			for (int i = 0; i < n-4; i++) {
				input.next();
			}
			if (n == 3) c = b;
			else c = input.next();
			d = input.next();
			if (a.charAt(1)==b.charAt(0)) {
				int ans = 0;
				String x, y;
				x = y = "";
				if (a.charAt(1)==c.charAt(n-1)) {
					ans++;
					int i = n - 1;
					x = "\n" + i + " " + n;
				}
				if (a.charAt(1)==d.charAt(n-2)) {
					ans++;
					int i = n-1;
					y = "\n" + n + " " + i;
				}
				System.out.println(ans + x + y);
			}
			else if (c.charAt(n-1)==d.charAt(n-2)) {
				int ans = 0;
				String x, y;
				x = y = "";
				if (a.charAt(1)==d.charAt(n-2)) {
					ans++;

					x = "\n" + 1 + " " + 2;
				}
				if (b.charAt(0)==d.charAt(n-2)) {
					ans++;
					y = "\n" + 2 + " " + 1;
				}
				System.out.println(ans + x + y);
			}
			else {
				if (a.charAt(1)==c.charAt(n-1)) {
					System.out.println(2 + "\n" + 2 + " " + 1 + "\n" + (n-1) + " " + n);
				} else System.out.println(2 + "\n" + 2 + " " + 1 + "\n" + n + " " + (n-1));
			}
		}
	}
	public static int[] mergeSort(int[] ara) {
		int f, l, m;
		f = 0;
		l = ara.length;
		m = (f+l)/2;
		if (m==0) {
			int[] ar = {ara[0]};
			return ar;
		}
		int[] ar1 = mergeSort(Arrays.copyOfRange(ara, f, m));
		int[] ar2 = mergeSort(Arrays.copyOfRange(ara, m, l));
		int i, j, k;
		for (i = 0, j = 0, k = 0; i < ar1.length && j < ar2.length; ) {
			if (ar1[i] < ar2[j]) ara[k++] = ar1[i++];
			else ara[k++] = ar2[j++];
		}
		if (i == ar1.length) while (k < ara.length) ara[k++] = ar2[j++];
		else while (k < ara.length) ara[k++] = ar1[i++];
		return ara;
	}
}
