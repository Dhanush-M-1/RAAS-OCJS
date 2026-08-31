import java.io.*;
import java.util.*;
import java.math.*;

public class C implements Runnable {
	private final boolean useStandardIO = true;
	private final String inFile = ".in";
	private final String outFile = ".out";

	boolean go(long x, long y, long a, long b){
		long d = -a*a-b*b;
		if (d == 0){
			return x == 0 && y == 0;
		}
		long k = -x*a-y*b;
		long t = a*y-b*x;
		
		return k % d == 0 && t % d == 0;
	}
	
	private void solve() throws IOException {
		long ax = nextLong(), ay=nextLong();
		long bx = nextLong(), by=nextLong();
		long cx = nextLong(), cy=nextLong();
		boolean can = false;
		long nx = bx-ax, ny = by-ay;
		
		can = can || go(nx, ny, cx, cy);
		
		nx = bx-ay; ny = by+ax;
		
		can = can || go(nx, ny, cx, cy);
		
		nx = bx+ax; ny = by+ay;
		
		can = can || go(nx, ny, cx, cy);
		
		nx = bx+ay; ny = by-ax;
		
		can = can || go(nx, ny, cx, cy);
		
		if (can) writer.println("YES"); else writer.println("NO");
	}

	public static void main(String[] args) {
		new Thread(null, new C(), "", 64 * 1024 * 1024).run();
	}

	BufferedReader reader;
	StringTokenizer tokenizer;
	PrintWriter writer;

	public void run() {
		try {
			try {
				Locale.setDefault(Locale.US);
			} catch (Exception e) {
			}
			if (useStandardIO) {
				reader = new BufferedReader(new InputStreamReader(System.in));
				writer = new PrintWriter(System.out);
			} else {
				reader = new BufferedReader(new FileReader(inFile));
				writer = new PrintWriter(new FileWriter(outFile));
			}
			tokenizer = null;
			solve();
			//reader.close();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}

	double nextDouble() throws IOException {
		return Double.parseDouble(nextToken());
	}

	BigInteger nextBigInteger() throws IOException {
		return new BigInteger(nextToken());
	}

	String nextToken() throws IOException {
		while (tokenizer == null || !tokenizer.hasMoreTokens()) {
			tokenizer = new StringTokenizer(reader.readLine());
		}
		return tokenizer.nextToken();
	}
}