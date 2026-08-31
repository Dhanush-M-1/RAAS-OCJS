
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		new Main().solver();
	}

	void solver() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] a = new long[n + 2];
		for (int i = 0; i < n; ++i) {
			a[i + 1] = sc.nextLong();
		}
		a[0] = 1;
		a[a.length - 1] = 1000000;
		long ans = Long.MAX_VALUE / 3;
		for (int i = 0; i + 1 < a.length; ++i) {
			ans = Math.min(ans, Math.max(a[i] - 1, 1000000 - a[i + 1]));
		}
		System.out.println(ans);
	}

	void tr(Object... objects) {
		System.out.println(Arrays.deepToString(objects));
	}
}
