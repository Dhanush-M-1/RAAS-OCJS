import java.util.*;
import java.io.*;

public class C {
	static class Solver{
		int n, k, s, t;
		int[] g;
		Car[] cars;
		
		public void solve(InputReader in, PrintWriter out) {
			read(in);
			Arrays.sort(cars);
			Arrays.sort(g);
			int l = 0, r = n-1, m, minVol = -1;
			while (l <= r) {
				m = (l+r)/2;
				if (isGood(cars[m])) {
					minVol = m;
					r = m-1;
				} else {
					l = m+1;
				}
			}
			if (minVol < 0) {
				out.println(-1);
				return;
			}

			int minCost = cars[minVol].cost;
			for (int i = minVol+1; i < n; ++ i)
				minCost = Math.min(minCost, cars[i].cost);
			out.println(minCost);
		}

		boolean isGood(Car car) {
			int time = 0, dist, acDist;
			// System.out.format("volume = %d%n", car.vol);
			for (int i = 0; i <= k; ++ i) {
				dist = (i < k ? g[i] : s) - (i > 0 ? g[i-1] : 0);
				acDist = Math.min(car.vol - dist, dist);
				// System.out.format("dist = %d, acDist = %d, time = %d%n", dist, acDist, time);
				if (acDist < 0) return false;
				time += acDist + (dist - acDist)*2;
			}
			return time <= t;
		}

		void read(InputReader in) {
			n = in.nextInt();
			k = in.nextInt();
			s = in.nextInt();
			t = in.nextInt();
			cars = new Car[n];
			g = new int[k];
			for (int i = 0; i < n; ++ i) {
				cars[i] = new Car(in.nextInt(), in.nextInt());
			}
			for (int i = 0; i < k; ++ i) {
				g[i] = in.nextInt();
			}
		}

		class Car implements Comparable<Car>{
			int cost, vol;

			public Car(int c, int v) {
				cost = c;
				vol = v;
			}

			public int compareTo(Car other) {
				return this.vol - other.vol;
			}
		}
	}

	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		PrintWriter out = new PrintWriter(System.out);
		Solver solver = new Solver();
		solver.solve(in, out);
		out.close();
	}

	static class InputReader{
		BufferedReader reader;
		StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream));
		}

		String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch(IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}
	}
}