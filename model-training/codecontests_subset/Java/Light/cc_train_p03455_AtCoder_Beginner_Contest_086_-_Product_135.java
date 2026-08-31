import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Integer a = sc.nextInt();
		Integer b = sc.nextInt();

		if(a%2 == 1 && b%2 == 1) {
			System.out.println("Odd");
		}
		else {
			System.out.println("Even");
		}
	}
}