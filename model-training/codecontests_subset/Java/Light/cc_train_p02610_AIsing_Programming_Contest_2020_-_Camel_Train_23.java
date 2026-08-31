import java.util.*;
import java.util.stream.Collectors;
import java.io.*;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;

public class Main {

	public static void main(String[] args) throws IOException {
		InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
		BufferedReader in = new BufferedReader(reader);
		int T = Integer.parseInt(in.readLine());
		for (int t = 0; t < T; ++t) {
			Main ins = new Main(in);
			ins.calc();
			ins.showResult();
		}
	}

	int N;
	Tuple[] tuples;
	long result = 0L;
	Set<Tuple>[] lefts, rights;

	static class Tuple {
		int K;
		long L, R;

		Tuple(int K, long L, long R) {
			this.K = K;
			this.L = L;
			this.R = R;
		}

		int getType() {
			if (L > R) {
				return 1;
			} else if (L < R) {
				return -1;
			} else {
				return 0;
			}
		}

		long getBase() {
			return Math.min(L, R);
		}

		long getProfit() {
			return Math.abs(L - R);
		}
	}

	Main(BufferedReader in) throws IOException {
		N = Integer.parseInt(in.readLine());
		tuples = new Tuple[N];
		for (int i = 0; i < N; ++i) {
			String[] tokens = in.readLine().split(" ");
			int K = Integer.parseInt(tokens[0]) - 1;
			long L = Long.parseLong(tokens[1]);
			long R = Long.parseLong(tokens[2]);
			tuples[i] = new Tuple(K, L, R);
		}

		// baseを足す
		for (int i = 0; i < N; ++i) {
			result += tuples[i].getBase();
		}

		lefts = new Set[N];
		rights = new Set[N];
		for (int i = 0; i < N; ++i) {
			lefts[i] = new HashSet<Tuple>();
			rights[i] = new HashSet<Tuple>();
		}
		for (int i = 0; i < N; ++i) {
			if (tuples[i].getType() > 0) {
				// Lの方が大きい-> leftsに足す
				Tuple t = tuples[i];
				lefts[t.K].add(t);
			} else if (tuples[i].getType() < 0) {
				// Rの方が大きい
				Tuple t = tuples[i];
				if (t.K + 1 < N) {
					rights[t.K + 1].add(t);
				}
			}
		}
	}

	void calc() {
		Queue<Tuple> leftQue = new PriorityQueue<>(new Comparator<Tuple>() {
			@Override
			public int compare(Tuple o1, Tuple o2) {
				return Long.compare(o1.getProfit(), o2.getProfit());
			}
		});
		for (int i = 0; i < N; ++i) {
			leftQue.addAll(lefts[i]);
			while (leftQue.size() > i + 1) {
				leftQue.poll();
			}
		}
		Queue<Tuple> rightQue = new PriorityQueue<>(new Comparator<Tuple>() {
			@Override
			public int compare(Tuple o1, Tuple o2) {
				return Long.compare(o1.getProfit(), o2.getProfit());
			}
		});
		for (int i = N - 1; i >= 0; --i) {
			rightQue.addAll(rights[i]);
			while (rightQue.size() > N - i) {
				rightQue.poll();
			}
		}
		while (!leftQue.isEmpty()) {
			Tuple t = leftQue.poll();
			result += t.getProfit();
		}
		while (!rightQue.isEmpty()) {
			Tuple t = rightQue.poll();
			result += t.getProfit();
		}
	}

	void showResult() {
		System.out.println(result);
	}
}