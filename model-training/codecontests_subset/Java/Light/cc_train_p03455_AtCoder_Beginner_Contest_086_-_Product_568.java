import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();

		String result = a%2 == 0 || b%2 == 0 ? "Even" : "Odd";

		System.out.println(result);
	}
}
