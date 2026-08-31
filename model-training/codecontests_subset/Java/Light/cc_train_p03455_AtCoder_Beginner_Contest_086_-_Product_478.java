import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int a,b;
		Scanner scan = new Scanner(System.in);
		a = scan.nextInt();
		b = scan.nextInt();
		if((a*b)%2 == 1) {
			System.out.println("Odd");
		}else {
			System.out.println("Even");
		}

	}
}
