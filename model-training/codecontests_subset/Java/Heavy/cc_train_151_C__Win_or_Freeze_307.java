import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SolC {

	static Scanner in;
	static PrintWriter out;

	public static void main(String[] args) {
		in = new Scanner(System.in);
		out = new PrintWriter(System.out);

		new SolC().run();

		in.close();
		out.close();

	}

	private void run() {
		long n = in.nextLong();
		long q = (long) Math.ceil(Math.sqrt(n));
		List<Long> divs = new ArrayList<Long>();

		long k = n;
		long l = 2L;

		while (k != 1) {
			if (k % l == 0) {
				k = (long) k / l;
				//System.out.print(l + " ");
				divs.add(l);
				if (divs.size() > 2) break;
				
			} else {
				
				l++;
			}
			if (l > q) {
				divs.add(n);
				break;
			}
		}
		if (n == 1) {
			out.println(1);
			out.println(0);
		} else if (divs.size() > 2) {
			out.println("1");
			out.println(divs.get(0) * divs.get(1));
		} else if (divs.size() == 1) {
			out.println(1);
			out.println(0);
		} else {
			out.print(2);
		}

	}

}
