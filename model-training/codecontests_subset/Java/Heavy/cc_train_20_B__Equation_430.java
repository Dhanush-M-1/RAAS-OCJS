
import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class AlphaRound20_B implements Runnable {

	final boolean ONLINE_JUDGE = System.getProperty("ONLINE_JUDGE") != null;
	BufferedReader in;
	PrintWriter out;
	StringTokenizer tok = new StringTokenizer("");

	void init() throws IOException {
		if (ONLINE_JUDGE) {
			in = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(System.out);
		} else {
			in = new BufferedReader(new FileReader("input.txt"));
			out = new PrintWriter("output.txt");
		}
	}

	String readString() throws IOException {
		while (!tok.hasMoreTokens()) {
			tok = new StringTokenizer(in.readLine());
		}
		return tok.nextToken();
	}

	int readInt() throws IOException {
		return Integer.parseInt(readString());
	}

	@Override
	public void run() {
		try {
			long t1 = System.currentTimeMillis();
			init();
			solve();
			out.close();
			long t2 = System.currentTimeMillis();
			System.err.println("Time = " + (t2 - t1));
		} catch (Exception e) {
			e.printStackTrace(System.err);
			System.exit(-1);
		}
	}

	public static void main(String[] args) {
		new Thread(new AlphaRound20_B()).start();
	}

	void solve() throws IOException {
		Locale.setDefault(Locale.US);
		double a = readInt();
		double b = readInt();
		double c = readInt();
		if (a == 0 && b == 0 && c == 0) {
			out.print(-1);
			return;
		}
		if (a == 0 && b == 0 && c != 0) {
			out.print(0);
			return;
		}
		if (a == 0) {
			double ans = -c / b;
			out.printf("1\n%.12f", ans);
		} else {
			double d = b*b - 4*a*c;
			if (d < 0) {
				out.print(0);
				return;
			}
			if (d == 0) {
				double ans = -b / (2*a);
				out.printf("1\n%.12f", ans);
				return;
			}
			double ans1 = (-b - sqrt(d)) / (2*a);
			double ans2 = (-b + sqrt(d)) / (2*a);
			if (ans1 > ans2) {
				double t = ans1;
				ans1 = ans2;
				ans2 = t;
			}
			out.printf("2\n%.12f\n%.12f", ans1, ans2);
		}
	}
	
}
