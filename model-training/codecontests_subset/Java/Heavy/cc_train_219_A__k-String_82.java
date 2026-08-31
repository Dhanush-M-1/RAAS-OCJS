import java.io.*;
import java.util.*;
import java.math.*;

public class A {
	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;
	static Random rnd;

	void solve() throws IOException {
		int k = nextInt();
		String s = nextToken();
		boolean fail = false;
		
		if(s.length() % k != 0)
			fail = true;
		
		int[] dic = new int[26];
		for(int i = 0; i < s.length(); i++)
			dic[s.charAt(i) - 'a']++;
		
		StringBuilder oneCopy = new StringBuilder();
		
		for(int i = 0; i < dic.length; i++) {
			int howMuch = dic[i] / k;
			
			if(dic[i] % k != 0)
				fail = true;
			
			for(int j = 0; j < howMuch; j++)
				oneCopy.append((char) ('a' + i));
		}
		
		StringBuilder res = new StringBuilder();
		
		while(!fail && res.length() < s.length())
			res.append(oneCopy);
		
		out.println(fail ? "-1" : res);
	}

	public static void main(String[] args) {
		new A().run();
	}

	public void run() {
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(System.out);

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

			if (line == null)
				return null;

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