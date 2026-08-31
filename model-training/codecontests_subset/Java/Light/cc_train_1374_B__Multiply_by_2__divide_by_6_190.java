import java.util.Scanner;

public class MultiplyByTWoDivideBySix1374B {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testCases = scanner.nextInt();

		for (int i = 0; i < testCases; i++) {
			int a = scanner.nextInt();
			int ans = 0;
			
			while (a % 3 == 0) {
				if (a % 6 == 0) {
					a = a / 6;
					ans++;
					continue;
				}
				a = a * 2;
				ans++;
			}
			System.out.println(a != 1 ? -1 : ans);
		}//testCases
	}
}