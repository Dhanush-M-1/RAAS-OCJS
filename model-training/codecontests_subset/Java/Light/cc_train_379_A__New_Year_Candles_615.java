import java.util.Scanner;

public class _A_New_Year_Candles_ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner obj = new Scanner(System.in);
		int a = obj.nextInt();
		int b = obj.nextInt();

		int tot = a;


		while (a >= b) {
			int x = a / b;
			int y = a % b;
			tot += x;
			a = x + y;

		}

		System.out.println(tot);

	}

}
