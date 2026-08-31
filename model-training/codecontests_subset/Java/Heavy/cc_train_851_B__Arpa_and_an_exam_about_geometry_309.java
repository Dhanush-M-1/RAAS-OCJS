import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
				PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))) {
			out.println(solve(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt()));
		}
	}

	private static String solve(long x0, long y0, long x1, long y1, long x2, long y2) {
		if ((y1 - y0) * (x2 - x1) == (y2 - y1) * (x1 - x0)) {
			return "No";
		}
		if ((y1 - y0) * (y1 - y0) + (x1 - x0) * (x1 - x0) == (y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1)) {
			return "Yes";
		}
		return "No";
	}

}
