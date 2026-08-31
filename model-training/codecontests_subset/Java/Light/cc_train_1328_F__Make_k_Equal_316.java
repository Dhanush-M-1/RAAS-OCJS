import java.util.Arrays;
import java.util.Scanner;

public class S {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = sc.nextInt();
		Arrays.sort(a);
		int m = 0;
		int min1 = 0, min = 10000000;
		int x = 1;
		int o = 0;
		for (int i = 0; i <= a[n - 1]; i++) {
			m = 0;
			min1 = 0;
			o = 0;
			x = 1;
			for (int j = 0; j < n; j++) {
				if (a[j] == i)
					m++;
				else {
					while (a[j] / x != i && a[j] / x > i) {
						x = 2 * x;
						o++;
					}
					if (a[j] / x == i) {
						m++;
						min1 += o;
					}
				}
				if (m == k) {
					min = Math.min(min, min1);
					break;
				}
			}
		}
		System.out.println(min);
	}
}
