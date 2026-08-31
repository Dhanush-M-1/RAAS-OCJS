import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		if (a == b + c || b == a + c || c == a + b) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}

}
