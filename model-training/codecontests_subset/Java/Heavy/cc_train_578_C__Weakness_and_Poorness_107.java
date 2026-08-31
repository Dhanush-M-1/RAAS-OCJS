import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class E579 {

	public static void main(String[] args) throws IOException {
		initReader();
		int n = nextInt();
		long arr[] = new long[n];
		double left = Double.MAX_VALUE;

		double right = Double.MIN_VALUE;
		for (int i = 0; i < n; ++i) {
			arr[i] = nextLong();
			right = Math.max(arr[i], right);
			left = Math.min(arr[i], left);
		}
		int count = 60;
		while (count-- > 0) {
			double mid = (left + right) / 2;
			if (cal(arr, mid)) {
				right = mid;
			} else {
				left = mid;
			}
		}

		System.out.printf("%.7f\n", getAns(arr, right));

	}

	private static double getAns(long[] arr, double mark) {
		double left = 0;
		double right = 0;
		int sign = -1;
		// PriorityQueue<Double> getMin = new PriorityQueue<Double>();
		// PriorityQueue<Double> getMax = new PriorityQueue<Double>();
		double min = 0;
		double max = 0;
	
		double pre = 0;
		for (int i = 0; i < arr.length; ++i) {
			pre += arr[i] - mark;
			double r = pre - min;
			double l = pre - max;
			if (r >= 0) {
				right = Math.max(right, r);
			}
			sign = -sign;
			if (l <= 0) {
				left = Math.min(l, left);
			}
			//getMin.add(pre);
			//getMax.add(-pre);
			min = Math.min(pre, min);
			max = Math.max(pre, max);
		}

		return Math.max(Math.abs(left), right);
	}

	private static boolean cal(long[] arr, double mid) {
		double left = 0;
		double right = 0;
		double min = 0;
		double max = 0;
		double pre = 0;
		for (int i = 0; i < arr.length; ++i) {
			pre += arr[i] - mid;
			double r = pre - min;
			double l = pre - max;
			if (r >= 0) {
				right = Math.max(right, r);
			}
			if (l <= 0) {
				left = Math.min(l, left);
			}
			min = Math.min(pre, min);
			max = Math.max(pre, max);
		}

		if (Math.abs(left) > Math.abs(right)) {
			return true;
		} else {
			return false;
		}
	}

	static BufferedReader reader;
	static StringTokenizer tokenizer;

	public static void initReader() {
		reader = new BufferedReader(new InputStreamReader(System.in));
		tokenizer = new StringTokenizer("");
	}

	static String next() throws IOException {
		while (!tokenizer.hasMoreTokens()) {
			String n = reader.readLine();
			if (n == null) {
				return null;
			}
			tokenizer = new StringTokenizer(n);

		}
		return tokenizer.nextToken();
	}

	static String nextLine() throws IOException {
		return reader.readLine();
	}

	static Integer nextInt() throws IOException {
		String next = next();
		if (next == null) {
			return null;
		}
		return Integer.parseInt(next);
	}

	static long nextLong() throws IOException {
		return Long.parseLong(next());
	}

	static Double nextDouble() throws IOException {
		return Double.parseDouble(next());
	}
}
