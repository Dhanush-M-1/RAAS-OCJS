import java.io.PrintWriter;
import java.util.Scanner;

public class PhoneNumbers {

	void solve(Scanner s, PrintWriter out) {
		s.next();
		int e = 0, o = 0;
		for (char c : s.next().toCharArray())
			if (c == '8')
				e++;
			else
				o++;
		int lo = 0, hi = e, f = 0;
		while (lo <= hi) {
			int x = lo + (hi - lo) / 2;
			if (e >= x && (o + e - x) / 10 >= x)
				lo = 1 + (f = x);
			else
				hi = x - 1;
		}
		out.println(f);
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		new PhoneNumbers().solve(s, out);
		out.close();
		s.close();
	}

}
