import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		solve();
	}

	private static void solve() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		sc.close();

		int count = 0;
		for (int i = 0; i < n; i++) {
			int minIndex = i;
			for (int j = i; j < n; j++) {
				if (a[j] < a[minIndex]) {
					minIndex = j;
				}
			}
			if (minIndex != i) {
				int tmp = a[i];
				a[i] = a[minIndex];
				a[minIndex] = tmp;
				count++;
			}
		}

		for (int i = 0; i < n; i++) {
			System.out.print(a[i]);
			if (i != n - 1) {
				System.out.print(" ");
			}
		}
		System.out.print("\n");
		System.out.println(count);
	}
}