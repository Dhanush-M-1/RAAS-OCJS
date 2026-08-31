import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class NewYEarBookReading {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		int w[] = new int[n];
		for (int i = 0; i < n; i++)
			w[i] = sc.nextInt();
		boolean[] seen = new boolean[n];
		ArrayList<Integer> l = new ArrayList<Integer>();
		Stack<Integer> s = new Stack<Integer>();
		Stack<Integer> s2 = new Stack<Integer>();

		for (int i = 0; i < m; i++) {
			int b = sc.nextInt() - 1;
			if (!seen[b]) {
				seen[b] = true;
				s2.push(b);
			}
			l.add(b);
		}
		while (!s2.isEmpty())
			s.push(s2.pop());
		int min = 0;
		for (int i = 0; i < l.size(); i++) {
			int cur = l.get(i);
			Stack<Integer> temp = new Stack<Integer>();
			while (true) {
				int popped = s.pop();
				if (cur == popped) {
					while (!temp.isEmpty()) {
						s.push(temp.pop());
						min += w[s.peek()];
					}
					s.push(popped);
					break;
				}
				temp.add(popped);
			}
		}

		System.out.println(min);

	}

	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		public boolean ready() throws IOException {
			return br.ready();
		}

		Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}

	}
}
