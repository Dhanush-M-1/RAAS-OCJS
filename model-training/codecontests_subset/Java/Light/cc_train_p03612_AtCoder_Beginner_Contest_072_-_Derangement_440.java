import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 値を取得
		int n = sc.nextInt();
		int[] p = new int[n];
		int ans = 0;

		for (int i = 0; i < n; i++) {
			p[i] = sc.nextInt();
		}

		for (int i = 0; i < n - 1; i++) {
			if (p[i] == i + 1) {
				int a = p[i + 1];
				p[i + 1] = p[i];
				p[i] = a;
				ans++;
			}
		}

		if (p[n - 1] == n) {
			int a = p[n - 1];
			p[n - 1] = p[n - 2];
			p[n - 2] = a;
			ans++;
		}

		System.out.println(ans);

		sc.close();
	}
}
