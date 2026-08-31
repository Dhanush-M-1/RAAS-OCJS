import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		int[][] f = new int[n][10];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 10; j++) {
				f[i][j] = sc.nextInt();
			}
		}
		int[][] p = new int[n][11];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 11; j++) {
				p[i][j] = sc.nextInt();
			}
		}
		int a[], b, idx, cnt, tmp, max = Integer.MIN_VALUE;
		for (int i = 1; i < 1024; i++) {
			int t = i;
			b = 512;
			idx = 9;
			a = new int[10];
			while (idx >= 0) {
				if (t / b > 0) {
					a[idx]++;
					t = t - b;
				}
				b = b / 2;
				idx--;
			}
			tmp = 0;
			for (int j = 0; j < n; j++) {
				cnt = 0;
				for (int k = 0; k < 10; k++) {
					if (a[k] == f[j][k] && a[k] == 1) {
						cnt++;
					}
				}
				tmp += p[j][cnt];
			}
			max = Math.max(max, tmp);
		}
		System.out.println(max);
	}
}
