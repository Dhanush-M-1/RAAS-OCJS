import java.util.*;

public class Main {
	static final int MOD = 1000000007;
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] arr = new int[n + 1];
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < m; i ++) {
			set.add(sc.nextInt());
		}
		arr[0] = 1;
		if (set.contains(1)) {
			arr[1] = 0;
		} else {
			arr[1] = 1;
		}
		for (int i = 2; i <= n; i++) {
			if (set.contains(i)) {
				arr[i] = 0;
			} else {
				int x = arr[i - 2] + arr[i - 1];
				x %= MOD;
				arr[i] = x;
			}
		}
		System.out.println(arr[n]);
	}
}
