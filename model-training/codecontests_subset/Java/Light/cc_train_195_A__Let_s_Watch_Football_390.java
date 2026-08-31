import java.util.Scanner;

/**
 * @author artyom
 */
public class LetsWatchFootball {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
		System.out.println(divCeil(c * (a - b), b));
    }

	private static int divCeil(int x, int y) {
		int res = x / y;
		if (x % y > 0) {
			++res;
		}
		return res;
	}
}