import java.util.Scanner;

/**
 * @author dzimiks
 * Date: 25-08-2019 at 15:58
 */
public class TaskA {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();

		while (t-- > 0) {
			int a = in.nextInt();
			int b = in.nextInt();
			int n = in.nextInt();

			if (n == 0) {
				System.out.println(a);
			} else if (n == 1) {
				System.out.println(b);
			} else {
				if (n % 3 == 0) {
					System.out.println(a);
				} else if (n % 3 == 2) {
					System.out.println(a ^ b);
				} else if (n % 3 == 1) {
					System.out.println(b);
				}
			}
		}

		in.close();
	}
}
