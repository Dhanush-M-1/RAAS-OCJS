import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		sc.close();

		int ans = 0;
		for (int i = 0; i < n; i++) {
			ans += a[i] - 1;
		}
		System.out.println(ans);
	}
}
