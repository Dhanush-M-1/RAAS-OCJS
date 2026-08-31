import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		ArrayList<Integer> a = new ArrayList<Integer>(), count = new ArrayList<Integer> ();

		for (int i = 0; i <= m; i++) {
			count.add(0);
		}

		for (int i = 0; i < n; i++) { 
			a.add(sc.nextInt());
			
			int x = a.get(i);
			count.set(x, count.get(x) + 1);
		}

		long ans = 0;

		for (int x: count) {
			ans += (n - x) * x;
		}

		System.out.print(ans / 2);
	}
}
