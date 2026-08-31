import java.util.*;

public class A168 {
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt (), x = sc.nextInt (), y = sc.nextInt ();
		int k = 0;
		if (n * y % 100 == 0) {
			k = (n * y) / 100 - x;
		}
		else {
			k = (n * y) / 100 + 1 - x;
		}
		if (k > 0) {
			System.out.print(k);
		}
		else {
			System.out.print(0);
		}
		sc.close ();
	}
}
