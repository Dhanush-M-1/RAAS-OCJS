import java.util.Scanner;

public class New_Year_Candles {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int out = a;
		while (a >= b) {
			out += (	a / b);
			a = (a / b) + (a % b);

		}
		System.out.println(out);
	}
}