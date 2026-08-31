import java.util.Scanner;

/**
 * @author Son-Huy TRAN
 * 
 */
public class P168A_WizardsAndDemonstration {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		int x = scanner.nextInt();
		int y = scanner.nextInt();

		scanner.close();

		int attention = (int) Math.ceil(y * 1.0 / 100 * n);
		int result = 0;

		if (x < attention) {
			result = attention - x;
		}

		System.out.println(result);
	}
}
