import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		if ((n * m) % 2 != 0) {
			System.out.println("Odd");
		}
		if ((n * m) % 2 == 0)
			System.out.println("Even");

	}
}
