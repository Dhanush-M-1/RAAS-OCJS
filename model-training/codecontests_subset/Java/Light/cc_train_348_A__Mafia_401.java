import java.io.*;
import java.util.*;

public class Main {
boolean eof;

public static void main(String[] args) throws IOException {
new Main().run();
}

public String nextToken() {
while (st == null || !st.hasMoreTokens()) {
try {
st = new StringTokenizer(br.readLine());
} catch (Exception e) {
eof = true;
return "-1";
}
}
return st.nextToken();
}

public int nextInt() {
return Integer.parseInt(nextToken());
}

public long nextLong() {
return Long.parseLong(nextToken());
}

double nextDouble() {
return Double.parseDouble(nextToken());
}

String nextLine() throws IOException {
return br.readLine();
}

BufferedReader br;
StringTokenizer st;
PrintWriter out;

void run() throws IOException {
InputStream input = System.in;
PrintStream output = System.out;
try {
File f = new File("input.in");
if (f.exists() && f.canRead()) {
input = new FileInputStream(f);
output = new PrintStream("output.out");
}
} catch (Throwable e) {
}
br = new BufferedReader(new InputStreamReader(input));
out = new PrintWriter(output);
solve();
br.close();
out.close();
}

	void solve() {
		long n = nextLong(), s = 0, m = 0, x;
		for (int i = 0; i < n; i++) {
			x = nextLong();
			s += x;
			if (x > m) {
				m = x;
			}
		}
		out.print(Math.max(m, (s - 1) / (n - 1) + 1));
	}
}