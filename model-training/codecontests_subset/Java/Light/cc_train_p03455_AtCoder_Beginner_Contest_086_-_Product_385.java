import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();

		if(a*b % 2 == 1) {
			System.out.println("Odd");
		}else {
			System.out.println("Even");
		}
	}

}