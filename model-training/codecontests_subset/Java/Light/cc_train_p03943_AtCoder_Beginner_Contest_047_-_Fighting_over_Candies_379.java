import java.util.Scanner;

public class Main {

	private static Scanner sc;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();

		// a+b:c
		// a:b+c
		// a+c:b

		if (a + b == c || a == b + c || a + c == b) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}

	}

}