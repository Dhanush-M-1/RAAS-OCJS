import java.util.*;

class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int A = scanner.nextInt();
		int B = scanner.nextInt();

		if ((A > 9 || A < 1) || (B > 9 || B < 1)) {
			System.out.println("-1");
		} else {
			System.out.println(A * B);
		}
	}
}