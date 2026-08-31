import java.io.*;
import java.util.*;
import java.math.*;

public class A implements Runnable {
	BufferedReader in;
	PrintWriter out;
	StringTokenizer st;
	Random rnd;
	
	void solve() throws IOException {
		int oneSecNeed = nextInt(), oneSecCan = nextInt(), length = nextInt();
		int needDownload = oneSecNeed * length;
		
		for(int wait = 0; wait < Integer.MAX_VALUE; wait++) {
			int downloaded = (wait + length) * oneSecCan;
			
			if(downloaded >= needDownload) {
				out.println(wait);
				break;
			}
		}
	}

	public static void main(String[] args) {
		final boolean oldChecker = false;
		
		if(oldChecker) {
			new Thread(null, new A(), "yarrr", 1 << 24).start();
		} else {

			new A().run();
		}
	}

	public void run() {
		try {
			final String className = this.getClass().getName().toLowerCase();

			try {
				in = new BufferedReader(new FileReader(className + ".in"));
				out = new PrintWriter(new FileWriter(className + ".out"));
			} catch (FileNotFoundException e) {
				in = new BufferedReader(new InputStreamReader(System.in));
				out = new PrintWriter(System.out);
			}

			rnd = new Random();

			solve();

			out.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(42);
		}
	}

	String nextToken() throws IOException {
		while (st == null || !st.hasMoreTokens()) {
			String line = in.readLine();

			if (line == null) {
				return null;
			}

			st = new StringTokenizer(line);
		}

		return st.nextToken();
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
}