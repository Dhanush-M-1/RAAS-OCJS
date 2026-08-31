import java.util.*;

public class NewYearCandles {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int totalhours = a;
		int temp = 0;
		while(a > 0 && a >= b) {
			totalhours += (a / b);
			temp = a % b;
			a = (a / b);
			a += temp;
		}
		System.out.println(totalhours);
		sc.close();
	}

}
