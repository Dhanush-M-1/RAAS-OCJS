import java.util.Scanner;

public class p2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scan.nextInt();
		}
		scan.close();

		int first = 1;
		int second = 2;
		boolean result = true;
		for (int i = 0; i < n; i++) {
			if (a[i] != first && a[i] != second) {
				result = false;
				break;
			}
			int player1 = a[i];
			int player2 = 6 - first - second;
			first = player1;
			second = player2;
		}

		if (result) {
			System.out.print("YES");
		} else {
			System.out.print("No");
		}
	}
}