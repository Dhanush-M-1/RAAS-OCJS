

import java.util.Scanner;

public class BearAndRaspberry {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int c = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = sc.nextInt();
		int ans = 0;
		for (int i = 1; i < n; i++)
			ans = Math.max(ans, a[i - 1] - a[i] - c);
		System.out.println(ans < 0 ? 0 : ans);
	}

}
