import java.util.*;
import java.io.*;

public class TestClass {
	static BufferedReader br;
	static StringTokenizer st;
	static PrintWriter out;

	public static void main(String[] args) {
		br = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(new OutputStreamWriter(System.out));
		solve();
		out.close();
	}

	public static void solve() {
		int length = nextInt();
		String s = nextLine();
		String answer = "";
		int max = -1;
		for(char i = 'A'; i <= 'Z'; i++) {
			for (char j = 'A'; j <= 'Z'; j++) {
				String bigram = i + "" + j;
				int count = 0;
				for (int k = 0; k < length - 1; k++) {
					if (s.charAt(k) == i && s.charAt(k + 1) == j)
						count += 1;
				}
				if (count > max) {
					answer = bigram;
					max = count;
				}
			}
		}
		out.println(answer);
	}

	private static int binarySearch(int i, int[] arr, int low) {
		int high = arr.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (arr[mid] == i)
				return mid;
			if (arr[mid] < i) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}

	static String next() {
		while (st == null || !st.hasMoreElements()) {
			try {
				st = new StringTokenizer(br.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return st.nextToken();
	}

	static int nextInt() {
		return Integer.parseInt(next());
	}

	static long nextLong() {
		return Long.parseLong(next());
	}

	static String nextLine() {
		String str = "";
		try {
			str = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}
}