import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		final Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int b = sc.nextInt();
		if(n*b%2==0) {
			System.out.println("Even");
		} else {
			System.out.println("Odd");
		}
	}
}