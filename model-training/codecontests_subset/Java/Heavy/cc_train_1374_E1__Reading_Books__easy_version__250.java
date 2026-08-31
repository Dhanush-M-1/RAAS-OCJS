import java.io.*;
import java.util.*;

@SuppressWarnings("unchecked")
public class Problem_E3 {
	static final long INF = Long.MAX_VALUE / 2;

	static class Book implements Comparable<Book> {
		int t, a, b, idx;

		Book(int t, int a, int b, int idx) {
			this.t = t;
			this.a = a;
			this.b = b;
			this.idx = idx;
		}

		public int compareTo(Book o) {
			return t == o.t ? idx - o.idx : t - o.t;
		}
	}

	static class Log {
		int idx;
		boolean tof;

		Log(int idx, boolean tof) {
			this.idx = idx;
			this.tof = tof;
		}
	}

	public static void main(String[] args) {
		InputReader in = new InputReader();
		StringBuilder out = new StringBuilder();

		int N = in.nextInt();
		int M = in.nextInt();
		int K = in.nextInt();
		Book[] B = new Book[N];
		for (int i = 0; i < N; i++) {
			int t = in.nextInt();
			int a = in.nextInt();
			int b = in.nextInt();
			B[i] = new Book(t, a, b, i + 1);
		}
		Arrays.sort(B);
		List<Book>[] list = new List[4];
		for (int i = 0; i < 4; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < N; i++) {
			int type = 3;
			if (B[i].a == 1 && B[i].b == 1) {
				type = 0;
			} else if (B[i].a == 1 && B[i].b == 0) {
				type = 1;
			} else if (B[i].a == 0 && B[i].b == 1) {
				type = 2;
			}
			list[type].add(B[i]);
		}
		if (list[0].size() + list[1].size() < K || list[0].size() + list[2].size() < K) {
			System.out.println(-1);
			return;
		}
		long ans = INF;
		long now = 0;
		TreeSet<Book> set1 = new TreeSet<>();
		TreeSet<Book> set2 = new TreeSet<>();
		List<Log> log = new ArrayList<>();
		boolean[] chk = new boolean[N + 1];
		for (Book c : list[3]) {
			set1.add(c);
		}
		for (int i = 0; i <= list[0].size() && i <= K; i++) {
			if (i + list[1].size() < K || i + list[2].size() < K || 2 * K - i > M) {
				continue;
			}
			for (int j = 0; j < i; j++) {
				Book c = list[0].get(j);
				now += c.t;
				set2.add(c);
				log.add(new Log(c.idx, true));
			}
			int cnt = K - i;
			for (int j = 0; j < cnt; j++) {
				for (int k = 1; k < 3; k++) {
					Book c = list[k].get(j);
					now += c.t;
					set2.add(c);
					log.add(new Log(c.idx, true));
				}
			}
			for (int j = 0; j < 3; j++) {
				for (int k = j == 0 ? i : cnt; k < list[j].size(); k++) {
					set1.add(list[j].get(k));
				}
			}
			for (int j = 2 * K - i; j < M; j++) {
				Book c = set1.first();
				now += c.t;
				set2.add(c);
				set1.remove(c);
				log.add(new Log(c.idx, true));
			}
			for (Log l : log) {
				chk[l.idx] = l.tof;
			}
			log.clear();
			ans = now;
			break;
		}
		if (ans == INF) {
			System.out.println(-1);
			return;
		}
		for (int i = 0; i < list[0].size() && i < K; i++) {
			if (i + list[1].size() < K || i + list[2].size() < K || 2 * K - i > M) {
				continue;
			}
			Book c = list[0].get(i);
			if (set1.contains(c)) {
				set1.remove(c);
				set2.add(c);
				now += c.t;
				log.add(new Log(c.idx, true));
			}
			for (int j = 1; j < 3; j++) {
				c = list[j].get(K - i - 1);
				if (set2.contains(c)) {
					set2.remove(c);
					set1.add(c);
					now -= c.t;
					log.add(new Log(c.idx, false));
				}
			}
			while (set2.size() < M) {
				c = set1.first();
				now += c.t;
				set1.remove(c);
				set2.add(c);
				log.add(new Log(c.idx, true));
			}
			while (set2.size() > M) {
				c = set2.last();
				now -= c.t;
				set2.remove(c);
				set1.add(c);
				log.add(new Log(c.idx, false));
			}
			if (ans > now) {
				for (Log l : log) {
					chk[l.idx] = l.tof;
				}
				log.clear();
				ans = now;
			}
		}
		if (ans == INF) {
			System.out.println(-1);
			return;
		}
		out.append(ans).append('\n');
		for (int i = 1; i <= N; i++) {
			if (chk[i]) {
				out.append(i).append(' ');
			}
		}
		out.setCharAt(out.length() - 1, '\n');

		System.out.print(out);
	}

	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer st;

		public InputReader() {
			reader = new BufferedReader(new InputStreamReader(System.in));
		}

		public String next() {
			while (st == null || !st.hasMoreTokens()) {
				st = new StringTokenizer(nextLine());
			}
			return st.nextToken();
		}

		public String nextLine() {
			try {
				return reader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}
	}
}
