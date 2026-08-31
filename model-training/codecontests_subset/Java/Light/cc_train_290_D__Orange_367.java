import java.io.*;
import java.util.*;

public class Orange {
	public static void main(String[] args) {
		new Orange().run();
	}

	BufferedReader br;
	StringTokenizer in;
	PrintWriter out;

	public String nextToken() throws IOException {
		while (in == null || !in.hasMoreTokens()) {
			in = new StringTokenizer(br.readLine());
		}
		return in.nextToken();
	}

	public int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	public void solve() throws IOException {
		String s = br.readLine().toLowerCase();
		int l = nextInt();
		String ans = "";
		for (int i = 0; i < s.length(); i++) {
			char h = s.charAt(i);
			if (h < l + 97) {
				ans += (char) (h + 'A' - 'a');
			} else {
				ans += h;
			}
		}
		out.println(ans);
	}

	public void run() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(System.out);

			solve();

			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
