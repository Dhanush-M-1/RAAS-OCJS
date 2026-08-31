import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		int a = stdIn.nextInt();
		int b = stdIn.nextInt();

		if (a > 9 || b > 9) {
			System.out.println("-1");
			return;
		}

		System.out.println(a * b);
		return;
	}
}