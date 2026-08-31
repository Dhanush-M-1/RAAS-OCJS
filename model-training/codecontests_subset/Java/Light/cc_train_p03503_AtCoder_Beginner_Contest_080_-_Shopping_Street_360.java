import java.util.Scanner;

public class Main {
	static int max = Integer.MIN_VALUE;
	static int[]bit;
	static int[][]F;
	static int[][]P;
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		F = new int[N][10];
		P = new int[N][11];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < 5; j++) {
				F[i][2 * j] = sc.nextInt();
				F[i][2 * j + 1] = sc.nextInt();
			}
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j <= 10; j++) {
				P[i][j] = sc.nextInt();
			}
		}
		sc.close();

		bit = new int[10];
		rec(0);
		System.out.println(max);
	}
	static void rec(int k) {
		if(k == bit.length) {
			solve();
			return;
		}
		rec(k + 1);
		bit[k] = 1;
		rec(k + 1);
		bit[k] = 0;
	}
	static int cnt = 0;
	static void solve() {
		if(cnt == 0) {
			cnt ++;
			return;
		}
		int t = 0;
		int[]c = new int[N];
		for(int i = 0; i < N; i++) {
			int cnt = 0;
			for(int j = 0; j < 10; j++) {
				if(F[i][j] == 1 && bit[j] == 1) {
					cnt++;
				}
			}
			c[i] = cnt;
		}
		for(int i = 0; i < N; i++) {
			t += P[i][c[i]];
		}
		max = Math.max(max, t);
	}
}