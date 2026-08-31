import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Random;
import java.util.StringTokenizer;
import java.math.BigInteger;

public class Working {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		
		Solver s = new Solver();
		s.Solve(in, out);

		out.close();
	}
}

class Solver {
	public void Solve(InputReader in, PrintWriter out) {
		int n = in.nextInt();
		String st = in.next();
		
		for (int i = 0; i < n; ++i)
			for (int d = 1; d < n; ++d) {
				boolean Check = true;
				for (int k = 0; k < 5; ++k)
					if (i + k * d >= n || st.charAt(i + k * d) == '.') {
						Check = false;
						break;
					}
				if (Check) {
					out.print("yes");
					return;
				}
			}
		
		out.print("no");
	}
}

class InputReader {
	public BufferedReader reader;
	public StringTokenizer tokenizer;
	
	public InputReader(InputStream stream) {
		reader = new BufferedReader(new InputStreamReader(stream), 32768);
		tokenizer = null;
	}
	
	public String next() {
		while (tokenizer == null || !tokenizer.hasMoreTokens()) {
			try {
				tokenizer = new StringTokenizer(reader.readLine());
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		return tokenizer.nextToken();
	}
	
	public int nextInt() {
		return Integer.parseInt(next());
	}
	
	public long nextLong() {
		return Long.parseLong(next());
	}
}

