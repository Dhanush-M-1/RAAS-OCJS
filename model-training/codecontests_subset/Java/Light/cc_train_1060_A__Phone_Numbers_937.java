import java.util.Scanner;

public class PhoneNumbers_1060A {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		long eghit = input.next().chars().filter(x -> x == '8').count();
		System.out.println(Math.min(n / 11, eghit));
		input.close();
	}
}
