import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int m = Integer.parseInt(sc.next());
		int[] a = new int[n];
		int[] b = new int[n];
		int[] c = new int[m];
		int[] d = new int[m];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(sc.next());
			b[i] = Integer.parseInt(sc.next());
		}
		for (int i = 0; i < m; i++) {
			c[i] = Integer.parseInt(sc.next());
			d[i] = Integer.parseInt(sc.next());
		}
		for (int i = 0; i < n; i++) {
			int min = Integer.MAX_VALUE;
			int index = 0;
			for (int j = 0; j < m; j++) {
				int tem = Math.abs(a[i] - c[j]) + Math.abs(b[i] - d[j]);
				if (tem < min) {
					min = tem;
					index = j;
				}
			}
			System.out.println(index + 1);
		}
	}
}