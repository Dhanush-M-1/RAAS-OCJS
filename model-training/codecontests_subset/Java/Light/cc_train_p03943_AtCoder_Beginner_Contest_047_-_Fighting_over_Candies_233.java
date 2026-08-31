import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();

		String ans = "No";

		if ((a + b + c) % 2 == 0) {
			if (a == (b + c) || b == (c + a) || c == (a + b)) {
				ans = "Yes";
			}
		}


		System.out.println(ans);
		sc.close();
	}

}
