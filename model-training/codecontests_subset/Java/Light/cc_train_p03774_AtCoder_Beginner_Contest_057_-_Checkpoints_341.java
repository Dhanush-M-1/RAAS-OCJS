import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];
		int[] c = new int[m];
		int[] d = new int[m];
		int[] man = new int[m];
		int[] min = new int[n];
		int[] minnum = new int[n];
		final int INF = Integer.MAX_VALUE;
		Arrays.fill(min, INF);
		for (int i = 0; i < n; i++) {
			a[i] = scan.nextInt();
			b[i] = scan.nextInt();
		}
		for (int i = 0; i < m; i++) {
			c[i] = scan.nextInt();
			d[i] = scan.nextInt();
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				man[j] = Math.abs(a[i]-c[j])+Math.abs(b[i]-d[j]);
				if (min[i] > man[j]) {
					min[i] = man[j];
					minnum[i] = j+1;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			System.out.println(minnum[i]);
		}
	}
}
