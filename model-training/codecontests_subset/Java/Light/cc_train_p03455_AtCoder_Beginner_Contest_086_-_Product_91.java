import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int a = input.nextInt();
		int b = input.nextInt();
		if (a * b % 2 == 0)
			System.out.println("Even");
		else
			System.out.println("Odd");
	}

}