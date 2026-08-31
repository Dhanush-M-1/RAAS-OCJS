
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
public class code {
	public static void main(String[] args)throws IOException {
		FastReader sc = new FastReader();
		PrintWriter pw = new PrintWriter(System.out);
		int n = sc.nextInt();
		String s = sc.next();
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < n - 1; i++) {
			String res = s.substring(i, i + 2);
			if (!map.containsKey(res))
				map.put(res, 1);
			else
				map.put(res, map.get(res) + 1);
		}
		int max = 0;
		String ans = "";
		for (Map.Entry<String, Integer> m : map.entrySet()) {
			String r = m.getKey();
			int v = m.getValue();
			if (v > max) {
				ans = new String();
				max = v;
				ans = r;
			}
		}
		System.out.println(ans);

	}


	public static int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}


}
class Pair {
	int x, y;
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}






class FastReader {
	BufferedReader br;
	StringTokenizer st;

	public FastReader() {
		br = new BufferedReader(new
		                        InputStreamReader(System.in));
	}

	String next() {
		while (st == null || !st.hasMoreElements()) {
			try {
				st = new StringTokenizer(br.readLine());
			} catch (IOException  e) {
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