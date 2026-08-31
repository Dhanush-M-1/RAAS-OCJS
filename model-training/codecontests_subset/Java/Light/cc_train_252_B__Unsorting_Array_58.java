// practice with kaiboy
import java.io.*;
import java.util.*;

public class CF252B extends PrintWriter {
	CF252B() { super(System.out, true); }
	Scanner sc = new Scanner(System.in);
	public static void main(String[] $) {
		CF252B o = new CF252B(); o.main(); o.flush();
	}

	boolean sorted(int a, int b, int c) {
		return a < b && b < c || a > b && b > c;
	}
	void print(int i, int j) {
		println((i + 1) + " " + (j + 1));
	}
	void main() {
		int n = sc.nextInt();
		int[] aa = new int[n];
		for (int i = 0; i < n; i++)
			aa[i] = sc.nextInt();
		if (n <= 2 || n == 3 && aa[0] == aa[2]) {
			println(-1);
			return;
		}
		boolean same = true;
		for (int i = 1; i < n; i++)
			if (aa[i] != aa[0]) {
				same = false;
				break;
			}
		if (same) {
			println(-1);
			return;
		}
		int i1 = -1, i2 = -1, j1 = -1, j2 = -1;
		for (int k = 0; k < n; k++) {
			if (i1 == -1)
				i1 = k;
			else if (i1 != -1 && aa[i1] == aa[k])
				i2 = k;
			else if (j1 == -1)
				j1 = k;
			else if (j1 != -1 && aa[j1] == aa[k])
				j2 = k;
			else {
				int a = aa[i1], b = aa[j1], c = aa[k];
				if (i1 < j1) {
					if (sorted(a, b, c))
						print(i1, j1);
					else
						print(i1, k);
				} else {
					if (sorted(b, a, c))
						print(j1, i1);
					else
						print(j1, k);
				}
				return;
			}
		}
		if (i2 != -1 && j2 != -1)
			print(i1, j1);
		else if (i2 == -1)
			print(i1, i1 + 1);
		else {
			if (j1 - 0 <= n - 1 - j1)
				print(j1, j1 + 1);
			else
				print(j1 - 1, j1);
		}
	}
}
