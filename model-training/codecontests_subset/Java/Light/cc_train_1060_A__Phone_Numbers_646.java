import java.util.Scanner;

/**
 * Contest: Codeforces Round #513, Problem A
 *
 * @author Arturs Licis
 */
public class ProblemA {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		String digits = scan.next();

		int max = n / 11;
		int num8 = 0;
		for (int i = 0; i < n; i++) {
			char c = digits.charAt(i);
			if (c == '8') num8++;
		}

		System.out.println(Math.min(num8, max));
	}
}
