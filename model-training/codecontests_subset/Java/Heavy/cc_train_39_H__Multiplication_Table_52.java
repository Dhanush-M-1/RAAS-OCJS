import java.io.*;
import java.util.*;

public class A {

	void run() throws IOException {
		int n = ni();
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < n; j++) {
				int q = i * j;
				String w = "";
				while (q != 0) {
					w = q % n + w;
					q /= n;
				}
				pw.print(w + " ");
			}
			pw.println();
		}
	}

	String next() throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine());
		return st.nextToken();
	}

	int ni() throws IOException {
		return Integer.parseInt(next());
	}

	String nl() throws IOException {
		return br.readLine();
	}

	PrintWriter pw;
	BufferedReader br;
	StringTokenizer st;

	public static void main(String[] args) throws IOException {
		long timeout = System.currentTimeMillis();
		boolean CF = System.getProperty("ONLINE_JUDGE") != null;
		PrintWriter _pw = new PrintWriter(System.out);
		BufferedReader _br = new BufferedReader(CF ? new InputStreamReader(System.in) : new FileReader(new File("in.txt")));
		new A(_br, _pw).run();
		if (!CF) {
			_pw.println();
			_pw.println(System.currentTimeMillis() - timeout);
		}
		_br.close();
		_pw.close();
	}

	public A(BufferedReader _br, PrintWriter _pw) {
		br = _br;
		pw = _pw;
	}
}
