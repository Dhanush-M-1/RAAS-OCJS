import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] a,b,c,d;
		a = new int[N];
		b = new int[N];
		c = new int[M];
		d = new int[M];
		for (int i=0; i<N; i++) {
			a[i] = sc.nextInt();
			b[i] = sc.nextInt();
		}
		for (int i=0; i<M; i++) {
			c[i] = sc.nextInt();
			d[i] = sc.nextInt();
		}
		
		for (int i=0; i<N; i++) {
			long min = Long.MAX_VALUE;
			int ans = 0;
			for (int j=0; j<M; j++) {
				if (min > Math.abs(a[i] - c[j]) + Math.abs(b[i] - d[j])) {
					min = Math.abs(a[i] - c[j]) + Math.abs(b[i] - d[j]);
					ans = j + 1;
				}
			}
			System.out.println(ans);
		}
	}
}
