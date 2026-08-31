import java.io.PrintStream;
import java.util.Scanner;

public class K {

	static Scanner sc;
	static PrintStream ps;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		ps = System.out;
		long n = sc.nextInt();
		long t = n - 1;
		long m = 0;
		long s = 0;
		while (n-- > 0) {
			int ls = sc.nextInt();
			s += ls;
			m = Math.max(m, ls);
		}

		System.out.println(Math.max(m,

		((s + t - 1) / t)

		));

		sc.close();
	}
}
