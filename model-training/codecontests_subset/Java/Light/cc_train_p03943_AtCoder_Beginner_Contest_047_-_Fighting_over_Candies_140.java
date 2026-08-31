import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();

		double h = (double)(a + b + c) / 2; // half

		String result = "No";

		if (a == h || b == h || c == h) {
			result = "Yes";
		}

		System.out.println(result);

		sc.close();

	}

}
