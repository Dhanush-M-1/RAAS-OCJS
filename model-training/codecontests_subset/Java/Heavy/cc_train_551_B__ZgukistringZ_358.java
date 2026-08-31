import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader reader;
	static StringTokenizer tokenizer;
	static PrintWriter writer;

	static int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	static long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}

	static double nextDouble() throws IOException {
		return Double.parseDouble(nextToken());
	}

	static boolean eof = false;

	static String nextToken() throws IOException {
		while (tokenizer == null || !tokenizer.hasMoreTokens()) {
			tokenizer = new StringTokenizer(reader.readLine());
		}
		return tokenizer.nextToken();
	}

	public static void main(String[] args) throws IOException {
		tokenizer = null;
		// reader = new BufferedReader(new FileReader("war.in"));
		// writer = new PrintWriter(new FileWriter("war.out"));
		reader = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"));
		writer = new PrintWriter(System.out);
		banana();
		reader.close();
		writer.close();
	}

	static class P {
		int data, index;

		public P(int data, int index) {
			this.data = data;
			this.index = index;
		}
	}

	static void banana() throws IOException {
		String a = nextToken();
		String b = nextToken();
		String c = nextToken();

		int n = 'z' - 'a' + 1;

		int aa[] = new int[n];
		int bb[] = new int[n];
		int cc[] = new int[n];

		for (int i = 0; i < a.length(); ++i) {
			aa[a.charAt(i) - 'a']++;
		}

		for (int i = 0; i < b.length(); ++i) {
			bb[b.charAt(i) - 'a']++;
		}

		for (int i = 0; i < c.length(); ++i) {
			cc[c.charAt(i) - 'a']++;
		}

		StringBuilder sb = new StringBuilder();
		int first = 0;
		int second = 0;

		for (int i = 0; i <= a.length(); ++i) {
			boolean ok = true;
			for (int j = 0; j < n; ++j) {
				if (aa[j] < bb[j] * i)
					ok = false;
			}

			if (!ok)
				break;
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < n; ++j) {
				if (cc[j] == 0)
					continue;
				min = Math.min(min, (aa[j] - bb[j] * i) / cc[j]);
			}

			if (first + second < min + i) {
				first = i;
				second = min;
			}
		}

		for (int i = 0; i < n; ++i) {
			aa[i] -= first * bb[i] + second * cc[i];
			for (int j = 0; j < aa[i]; ++j) 
				sb.append((char)(i + 'a'));
		}
		for (int i = 0; i < first; ++i)
			sb.append(b);
		for (int i = 0; i < second; ++i)
			sb.append(c);
		

		writer.println(sb.toString());
	}
}