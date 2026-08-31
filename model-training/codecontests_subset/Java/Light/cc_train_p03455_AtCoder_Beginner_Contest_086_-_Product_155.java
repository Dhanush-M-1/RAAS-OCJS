import java.util.Scanner;

class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();

		sc.close();
		if (a % 2 == 0 || b % 2 == 0)
			System.out.println("Even");
		else
			System.out.println("Odd");
	}
}