import java.util.Scanner;

public class P195A_LetSWatchFootball {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int c = scanner.nextInt();
		scanner.close();

		int result = (int) (Math.ceil(a * c * 1.0 / b)) - c;
		System.out.println(result);
	}
}
