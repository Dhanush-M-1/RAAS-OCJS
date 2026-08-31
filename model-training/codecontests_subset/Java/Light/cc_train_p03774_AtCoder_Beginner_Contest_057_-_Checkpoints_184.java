import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N, M;
		N = sc.nextInt();
		M = sc.nextInt();
		int[] a = new int[N];
		int[] b = new int[N];
		int[] c = new int[M];
		int[] d = new int[M];
		for (int i = 0; i < N; i++) {
			a[i] = sc.nextInt();
			b[i] = sc.nextInt();
		}
		for (int i = 0; i < M; i++) {
			c[i] = sc.nextInt();
			d[i] = sc.nextInt();
		}

		for (int i = 0; i < N; i++) {
			int min = Math.abs(a[i] - c[0]) + Math.abs(b[i] - d[0]);
			int cp = 1;
			for (int j = 1; j < M; j++) {
				int num = Math.abs(a[i] - c[j]) + Math.abs(b[i] - d[j]);
				if(num < min) {
					cp = j + 1;
					min = num;
				}
			}
			System.out.println(cp);
		}
	}
}