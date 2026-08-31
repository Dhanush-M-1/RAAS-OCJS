import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt() - 1;
		}
		int[] b = new int[n];
		for (int i = 0; i < n; i++) {
			b[i] = sc.nextInt();
		}
		int[] c = new int[n - 1];
		for (int i = 0; i < n - 1; i++) {
			c[i] = sc.nextInt();
		}
		sc.close();

		int ans = 0;
		ans += b[a[0]];
		for (int i = 1; i < n; i++) {
			ans += b[a[i]];
			if (a[i - 1] + 1 == a[i]) {
				ans += c[a[i - 1]];
			}
		}
		System.out.println(ans);
	}
}
