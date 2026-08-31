import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_RunForYourPrize {
	static FastScanner scan = new FastScanner(System.in);

	public static void main(String[] args) {
		int n = scan.nextInt();
		long myplace = 1;
		long frindPlace = 1000000;
		long sec1 = 0;
		long sec2 = 0;
		ArrayList<Long> pos1 = new ArrayList<>();
		ArrayList<Long> pos2 = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			long temp = scan.nextLong();
			if (temp <= 1000000 / 2) {
				pos1.add(temp);
			} else {
				pos2.add(temp);
			}
		}
		int len1 = pos1.size();
		int len2 = pos2.size();
		for (int i = 0; i < len1; i++) {
			sec1 = sec1 + (pos1.get(i) - myplace);
			myplace += pos1.get(i) - myplace;
		}
		for (int i = len2 - 1; i >= 0 ; i--) {
			sec2 = sec2 + (frindPlace - pos2.get(i));
			frindPlace -= (frindPlace - pos2.get(i));
		}

		System.out.println(Math.max(sec1, sec2));

	}

	static class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		FastScanner(InputStream stream) {
			try {
				br = new BufferedReader(new InputStreamReader(stream));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());

		}
	}
}
