import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProblemB {
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		String[] abc = s.readLine().split(" ");
		
		long a = Long.valueOf(abc[0]);
		long b = Long.valueOf(abc[1]);
		long c = Long.valueOf(abc[2]);
		if (a == 0) {
			if (b == 0) {
				if (c == 0) {
					out.println(-1);
				} else {
					out.println(0);
				}
			} else {
				out.println(1);
				if (c == 0) {
					out.println("0.0000000");
				} else {
					double d = (-1.0d * c) / b;
					out.println(String.format("%07f", d));
				}
			}
		} else {
			if (a < 0) {
				a *= -1;
				b *= -1;
				c *= -1;
			}
			long D = b * b - 4 * a * c;
			if (D < 0) {
				out.println(0);
			} else if (D == 0) {
				out.println(1);
				if (b == 0) {
					out.println("0.0000000");
				} else {
					out.println(String.format("%07f", -b * 1.0d / (2 * a)));
				}
			} else {
				out.println(2);
				double rt = Math.sqrt(D);
				out.println(String.format("%07f", (-b * 1.0d - rt) / (2 * a)));
				out.println(String.format("%07f", (-b * 1.0d + rt) / (2 * a)));
			}
		}
		out.flush();
	}

	public static void debug(Object... os){
		System.err.println(Arrays.deepToString(os));
	}
}