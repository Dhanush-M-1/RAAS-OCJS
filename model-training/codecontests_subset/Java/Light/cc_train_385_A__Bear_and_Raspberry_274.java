
import java.util.Scanner;

public class BearandRaspberry {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int c = scanner.nextInt();

		int[] price = new int[n];
		for (int i = 0; i < price.length; i++) {
			price[i] = scanner.nextInt();
		}
		int mx = Integer.MIN_VALUE;
		for (int i = 0; i < price.length - 1; i++) {
			mx = Math.max(mx, price[i] - price[i + 1] - c);
		}
		if (mx > 0)
			System.out.println(mx);
		else
			System.out.println(0);

	}

}
