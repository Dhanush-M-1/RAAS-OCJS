import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		long[]a = new long[N];
		long[]b = new long[N];
		for(int i = 0; i < N; i++) {
			a[i] = sc.nextInt();
			b[i] = sc.nextInt();
		}
		long[]c = new long[M];
		long[]d = new long[M];
		for(int i = 0; i < M; i++) {
			c[i] = sc.nextInt();
			d[i] = sc.nextInt();
		}
		sc.close();
		int[]id = new int[N];
		Arrays.fill(id, 1);
		for(int i = 0; i < N; i++) {
			long t = Math.abs(a[i] - c[0]) + Math.abs(b[i] - d[0]);
			for(int j = 1; j < M; j++) {
				long k = Math.abs(a[i] - c[j]) + Math.abs(b[i] - d[j]);
				if(t > k) {
					t = k;
					id[i] = j + 1;
				}
			}
		}
		for(int i = 0; i < N; i++) {
			System.out.println(id[i]);
		}
	}
}