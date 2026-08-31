import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class main implements Runnable {
	StringTokenizer st;
	BufferedReader  in;
	PrintWriter     out;
	
	public static void main(String[] args) {
		new Thread(new main()).start();
	}
	public void run() {
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(System.out);
			solve();
		} catch (Exception e) {
			System.exit(73);
		} finally {
			out.flush();
			out.close();
		}
	}
	String nextToken()  throws IOException {
		while (st == null || !st.hasMoreTokens()) {
			st = new StringTokenizer(in.readLine());
		}
		return st.nextToken();
	}
	int nextInt()       throws NumberFormatException, IOException {
		return Integer.parseInt(nextToken());
	}
	long nextLong()     throws NumberFormatException, IOException {
		return Long.parseLong(nextToken());
	}
	double nextDouble() throws NumberFormatException, IOException {

		return Double.parseDouble(nextToken());
	}

	void solve() throws NumberFormatException, IOException {
		int r1 = nextInt(), r2 = nextInt(),
			c1 = nextInt(), c2 = nextInt(),
			d1 = nextInt(), d2 = nextInt();
		
		boolean status = false;
		
		for (int s1 = 1 ; s1 < 10 ; s1++) {
			int s2 = r1 - s1;
			int s3 = c1 - s1;
			int s4 = r2 - s3;
			
			if (s2 > 0   && s3 > 0   && s4 > 0   && s2 < 10  && s3 < 10  && s4 < 10  &&
			    s1 != s2 && s1 != s3 && s1 != s4 && s2 != s3 && s2 != s4 && s3 != s4 &&
			    d1 == (s1 + s4)      && d2 == (s2 + s3)      && c2 == (s2 + s4)) {
				out.println(s1 + " " + s2 + "\n" + s3 + " " + s4);
				status = true;
				break;
			}
		}
		
		if (!status) 
			out.println(-1);
	}
}