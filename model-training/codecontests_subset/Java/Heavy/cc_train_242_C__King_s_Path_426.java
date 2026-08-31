import java.io.IOException;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Sol3 {
	int a[][];
	boolean a1[];
	int aa;

	boolean bs(int x, int y) {
		int l = 0;
		if ((a[l][0] == x) && (a[l][1] == y)) {
			if (a1[l]) {
				return (false);
			}
			int k = l;
			while ((k < aa) && (a[k][0] == x) && (a[k][1] == y)) {
				a1[k] = true;
				k++;
			}
			return (true);
		}
		int r = aa;
		while (l + 1 < r) {
			int m = (l + r) / 2;
			if (a[m][0] > x) {
				r = m;
			}
			if (a[m][0] < x) {
				l = m;
			}
			if (a[m][0] == x) {
				if (a[m][1] > y) {
					r = m;
				}
				if (a[m][1] < y) {
					l = m;
				}
				if (a[m][1] == y) {
					if (a1[m]) {
						return (false);
					}
					int k = m;
					while ((k < aa) && (a[k][0] == x) && (a[k][1] == y)) {
						a1[k] = true;
						k++;
					}
					k = m;
					while ((k > 0) && ((a[k][0] == x) && (a[k][1] == y))) {
						a1[k] = true;
						k--;
					}
					return (true);
				}
			}

		}

		return (false);
	}

	void run() throws IOException {

		Scanner sc = new Scanner(System.in);
		int x1 = sc.nextInt();
		int y1 = sc.nextInt();
		int x2 = sc.nextInt();
		int y2 = sc.nextInt();
		int n = sc.nextInt();
		a1 = new boolean[100001];
		a = new int[100001][2];
		aa = 0;
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int z1 = sc.nextInt();
			int z2 = sc.nextInt();
			for (int j = z1; j <= z2; j++) {
				a[aa][0] = x;
				a[aa][1] = j;
				aa++;
			}

		}

		Arrays.sort(a, 0, aa, new Comparator<int[]>() {

			@Override
			public int compare(int[] x1, int[] x2) {
				if (x1[0] < x2[0]) {
					return -1;
				}
				if (x1[0] > x2[0]) {
					return 1;
				}
				if (x1[1] > x2[1]) {
					return 1;
				}
				if (x1[1] < x2[1]) {
					return -1;
				}
				return 0;
			}

		});

		// for (int i = 0; i < aa; i++) {
		// System.out.println(a[i][0] + " " + a[i][1]);
		// }

		int[][] b = new int[100001][3];
		b[0][0] = 0;
		b[0][1] = x1;
		b[0][2] = y1;
		int l = 0;
		int r = 1;
		while (l < r) {
			int x = b[l][1];
			int y = b[l][2];
			if (bs(x + 1, y)) {
				b[r][0] = b[l][0] + 1;
				b[r][1] = x + 1;
				b[r][2] = y;

				if ((b[r][1] == x2) && (b[r][2] == y2)) {
					break;
				}
				r++;
			}
			if (bs(x, y + 1)) {
				b[r][0] = b[l][0] + 1;
				b[r][1] = x;
				b[r][2] = y + 1;

				if ((b[r][1] == x2) && (b[r][2] == y2)) {
					break;
				}
				r++;
			}
			if (bs(x + 1, y + 1)) {
				b[r][0] = b[l][0] + 1;
				b[r][1] = x + 1;
				b[r][2] = y + 1;

				if ((b[r][1] == x2) && (b[r][2] == y2)) {
					break;
				}
				r++;
			}
			if (bs(x - 1, y)) {
				b[r][0] = b[l][0] + 1;
				b[r][1] = x - 1;
				b[r][2] = y;

				if ((b[r][1] == x2) && (b[r][2] == y2)) {
					break;
				}
				r++;
			}
			if (bs(x, y - 1)) {
				b[r][0] = b[l][0] + 1;
				b[r][1] = x;
				b[r][2] = y - 1;

				if ((b[r][1] == x2) && (b[r][2] == y2)) {
					break;
				}
				r++;
			}
			if (bs(x - 1, y - 1)) {
				b[r][0] = b[l][0] + 1;
				b[r][1] = x - 1;
				b[r][2] = y - 1;

				if ((b[r][1] == x2) && (b[r][2] == y2)) {
					break;
				}
				r++;
			}
			if (bs(x + 1, y - 1)) {
				b[r][0] = b[l][0] + 1;
				b[r][1] = x + 1;
				b[r][2] = y - 1;

				if ((b[r][1] == x2) && (b[r][2] == y2)) {
					break;
				}
				r++;
			}
			if (bs(x - 1, y + 1)) {
				b[r][0] = b[l][0] + 1;
				b[r][1] = x - 1;
				b[r][2] = y + 1;
				if ((b[r][1] == x2) && (b[r][2] == y2)) {
					break;
				}
				r++;
			}
			l++;

		}

		if (l >= r) {
			System.out.println("-1");
		} else {
			System.out.println(b[r][0]);
		}
	}

	public static void main(String[] args) throws IOException {
		new Sol3().run();
	}

}
