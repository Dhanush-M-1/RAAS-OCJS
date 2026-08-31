import java.util.Scanner;

class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int i1 = sc.nextInt();

		int i2 = sc.nextInt();

		if (i1 * i2 % 2 == 0) {

			System.out.println("Even");

		} else {

			System.out.println("Odd");

		}

		sc.close();

	}
}