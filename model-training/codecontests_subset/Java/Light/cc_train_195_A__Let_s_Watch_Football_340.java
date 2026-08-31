import java.util.Scanner;
import java.lang.Math;
public class Day11_195A {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		double a = scan.nextDouble();
		double b = scan.nextDouble();
		double c = scan.nextDouble();
		scan.close();
		double n = (a - b) * c ;
		double wait = Math.ceil(n / b);
		if (a <= b)
			wait = 0;
		int ans = (int)wait;	
		System.out.println(ans);
	}
}