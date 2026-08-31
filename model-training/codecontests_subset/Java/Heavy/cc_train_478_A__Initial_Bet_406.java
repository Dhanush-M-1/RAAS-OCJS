import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputReader in = new InputReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		new Task().go(in, out);
		out.close();
	}

}

class Task {
	public int maxn = 100010;
	int[] c = new int[5];
	int s = 0;
	public void go(InputReader in, PrintWriter out) {
		for(int i=0; i<5; i++) {
			c[i] = in.nextInt();
			s+=c[i];
		}
		if(s!=0&&(s%5)==0) out.println(s/5);
		else out.println(-1);
	}
}

class InputReader {
	BufferedReader bf;
	StringTokenizer st;

	InputReader(InputStreamReader is) {
		bf = new BufferedReader(is);
	}

	public String next() {
		if (st == null || !st.hasMoreElements()) {
			try {
				st = new StringTokenizer(bf.readLine());
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		return st.nextToken();
	}

	public int nextInt() {
		return Integer.parseInt(next());
	}

	public long nextLong() {
		return Long.parseLong(next());
	}

	public double nextDouble() {
		return Double.parseDouble(next());
	}
}
