import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner((System.in));
		int a = sc.nextInt();
		int b = sc.nextInt();
		String ans = "Even";

		if ((a * b) % 2 != 0) {
			ans = "Odd";
		}

		System.out.println(ans);

		sc.close();
	}
}
