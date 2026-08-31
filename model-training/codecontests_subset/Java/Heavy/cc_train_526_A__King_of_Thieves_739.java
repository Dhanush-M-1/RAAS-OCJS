import java.io.*;
import java.math.BigInteger;
import java.util.*;


public class Program {
	void solve() throws IOException {
		int n = nextInt();
		String str = nextToken();
		boolean yn = false;
		int d = (n - 1) / 4;
		int count;
		for (int i = 0; i < d; i++) {
			for (int j = d; j > 0 ; j--) {
				count = 0;
				for (int k = 0; k < n;) {
					if(str.charAt(k) == '.') {
						if (k + 4*j + 1 < n)
							k+=1;
						else
							k = k - count*j + 1;
						count=0;
					}
					else
					{
						count+=1;
						if (count == 5) {
							yn = true;
							break;
						}
						k += j;
					}
				}
				if (yn)
					break;
			}
			if (yn)
				break;
		}
		out.println(yn?"yes":"no");
	}

	public static void main(String[] args) throws IOException {
		new Program().run();
	}

	void run() throws IOException {
		reader = new BufferedReader(new InputStreamReader(System.in));
		tokenizer = null;
		out = new PrintWriter(new OutputStreamWriter(System.out));
		solve();
		reader.close();
		out.flush();
	}


	BufferedReader reader;
	StringTokenizer tokenizer;
	PrintWriter out;

	int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}

	double nextDouble() throws IOException {
		return Double.parseDouble(nextToken());
	}

	String nextToken() throws IOException {
		while (tokenizer == null || !tokenizer.hasMoreTokens()) {
			tokenizer = new StringTokenizer(reader.readLine());
		}
		return tokenizer.nextToken();
	}
}