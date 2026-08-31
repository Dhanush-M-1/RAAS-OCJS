import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static long N = sc.nextLong();
	static long P = sc.nextLong();
	static class Pair {
		public long x;
		public long y;
		public Pair(long x, long y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) {
		long ans = 1;
		Queue<Pair> que = new ArrayDeque<>();
		for (long i = 2; i*i <= P; i++) {
			if (P%i != 0) continue;
			long count = 0;
			while (P % i == 0) {
				count++;
				P /= i;
			}
//			System.out.println(count);
			Pair pair = new Pair(i, count);
			que.add(pair);
		}
		if (P != 1) {
			que.add(new Pair(P, 1));
		}
		while (!que.isEmpty()) {
			Pair pair2 = que.poll();
			for (int i = 0; i < pair2.y/N; i++) {
				ans *= pair2.x;
			}
		}
		System.out.println(ans);
	}
}

