

import java.util.Scanner;

public class New_Year_Candles {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int count= a ;
		while(a >= b) {
			count += a/b;
			a = a / b + (a % b);
		}
		System.out.println(count);
	}
}
