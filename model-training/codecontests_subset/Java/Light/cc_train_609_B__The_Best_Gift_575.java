import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		ArrayList<Integer> a = new ArrayList<>(), count = new ArrayList<> ();

		for (int i = 0; i <= m; ++i) {
			count.add(0);
		}

		for (int i = 0; i < n; ++i) { 
			int x = sc.nextInt();
			a.add(x);
			count.set(x, count.get(x) + 1);
		}

		int ans = 0;

		for (int i = 1; i < m; ++i) {
			for (int j = i + 1; j <= m; ++j) {
				ans += count.get(i) * count.get(j);
			}
		}

		System.out.print(ans);
	}
}