import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] a = new int[N]; int[] b = new int[N];
		int[] c = new int[M]; int[] d = new int[M];
		for (int i=0; i<N; i++) {
			a[i] = sc.nextInt();
			b[i] = sc.nextInt();
		}
		for (int i=0; i<M; i++) {
			c[i] = sc.nextInt();
			d[i] = sc.nextInt();
		}
		for (int i=0; i<N; i++) {
			int res = 1;
			int md = Math.abs(a[i] - c[0]) + Math.abs(b[i] - d[0]);
			for (int j=0; j<M; j++) {
				int cd = Math.abs(a[i] - c[j]) + Math.abs(b[i] - d[j]);
				if (md > cd) {
					md = cd;
					res = j+1;
				}
			}
			System.out.println(res);
		}
	}
}
