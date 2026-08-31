import java.util.*;
import java.io.*;

public class aaaaaaaaaaaaaaaa {
	static long x, y;
	public void run() throws Exception {
		FastReader file = new FastReader();
		x = -1L; y = -1L;
		long n = file.nextLong(); long p = file.nextLong(), w = file.nextLong(), d = file.nextLong();
		for (int i = 0; i <= Math.max(d, w); i++) {
			if (p >= Math.min(d, w) * i && (p - (i * Math.min(d, w))) % Math.max(d, w) == 0 && n - i - (p - (i * Math.min(d, w))) / Math.max(d, w) >= 0) {
				x = i; y = (p - (i * Math.min(d, w))) / Math.max(d, w);
				break;
			}
		}
		if (x == -1 && y == -1) System.out.println(-1);
		else System.out.println(y + " " + x + " " + (n - x - y));
	}
	

	public static void main(String[] args) throws Exception {
		new aaaaaaaaaaaaaaaa().run();
	}
	
	

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
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

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
