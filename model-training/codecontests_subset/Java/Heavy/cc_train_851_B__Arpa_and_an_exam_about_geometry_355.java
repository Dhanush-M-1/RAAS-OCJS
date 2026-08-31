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

	private static String solve(int x0, int y0, int x1, int y1, int x2, int y2) {
		if ((long) (y1 - y0) * (x2 - x1) == (long) (y2 - y1) * (x1 - x0)) {
			if (x2 == x0 && y2 == y0) {
				return "Yes";
			}
			return "No";
		}
		if ((long) (y1 - y0) * (y1 - y0) + (long) (x1 - x0) * (x1 - x0) == (long) (y2 - y1) * (y2 - y1)
				+ (long) (x2 - x1) * (x2 - x1)) {
			return "Yes";
		}
		return "No";
	}

}
