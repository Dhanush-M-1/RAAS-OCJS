import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.ArrayList;

public class A {
	private static StreamTokenizer in;
	private static PrintWriter out;
	static {
		in = new StreamTokenizer(new BufferedReader(new InputStreamReader(
				System.in)));
		out = new PrintWriter(System.out);
	}

	private static int nextInt() throws Exception {
		in.nextToken();
		return (int) in.nval;
	}

	private static String nextString() throws Exception {
		in.nextToken();
		return in.sval;
	}

	public static void main(String[] args) throws Exception {
		int n = nextInt();
		for (int i=1; i<n; i++) {
			for (int j=1; j<n; j++) {
				out.print(Integer.toString(i*j, n) + " ");
			}
			out.println();
		}
		out.flush();

	}
}