import java.util.Scanner;

public class NewYearCandles {

	public static void main(String[] args) {

		Scanner myScan = new Scanner(System.in);
		int a = myScan.nextInt();
		int b = myScan.nextInt();

		int hours = a;
		while (a / b >= 1) {
			hours += a / b;
			a = a / b + (a % b);
		}
		System.out.println(hours);
		myScan.close();
	}

}
