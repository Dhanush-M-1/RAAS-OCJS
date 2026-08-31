import java.util.Scanner;


public class NewYearCandles {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt(), b = scan.nextInt();
		int count = a;
		while(a >= b) {
			count += a / b;
			a = a / b + a % b;
		}
		System.out.println(count );
	}

}
