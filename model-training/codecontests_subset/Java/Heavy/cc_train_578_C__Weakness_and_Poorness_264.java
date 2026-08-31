import java.io.*;
import java.util.*;

public class cf579e implements Runnable {
	public static final String taskname = cf579e.class.getName();
	
	public StringTokenizer strtok;
	public BufferedReader inr;
	public PrintWriter out;

	public static void main(String[] args) {
		new Thread(new cf579e()).start();
	}

	public void run() {
		Locale.setDefault(Locale.US);
		boolean oj = System.getProperty("ONLINE_JUDGE") != null;
		try {
			inr = new BufferedReader(oj ? new InputStreamReader(System.in, "ISO-8859-1") : new FileReader(taskname + ".in"));
			out = new PrintWriter(oj ? new OutputStreamWriter(System.out, "ISO-8859-1") : new FileWriter(taskname + ".out"));
			solve();
		} catch (Exception e) {
			if (!oj)
				e.printStackTrace();
			System.exit(9000);
		} finally {
			out.flush();
			out.close();
		}
	}

	public String nextToken() throws IOException {
		while (strtok == null || !strtok.hasMoreTokens()) {
			strtok = new StringTokenizer(inr.readLine());
		}
		return strtok.nextToken();
	}

	public int nextInt() throws NumberFormatException, IOException {
		return Integer.parseInt(nextToken());
	}

	public long nextLong() throws NumberFormatException, IOException {
		return Long.parseLong(nextToken());
	}

	public double nextDouble() throws NumberFormatException, IOException {
		return Double.parseDouble(nextToken());
	}

	// Debugging

	public static void printArray(boolean[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j] ? '#' : '.');
			}
			System.out.print('\n');
		}
	}

	// Solution
	
	double find_max(int[] a, double x) {
		double ans = a[0] - x, sum = 0, min_sum = 0;
		for (int r = 0; r < a.length; ++r) {
			sum += a[r] - x;
			ans = Math.max(ans, sum - min_sum);
			min_sum = Math.min(min_sum, sum);
		}
		return ans;
	}
	
	double find_min(int[] a, double x) {
		double ans = -a[0] + x, sum = 0, min_sum = 0;
		for (int r = 0; r < a.length; ++r) {
			sum += -a[r] + x;
			ans = Math.max(ans, sum - min_sum);
			min_sum = Math.min(min_sum, sum);
		}
		return -ans;
	}
	

	public void solve() throws NumberFormatException, IOException {
		int n = nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = nextInt();
		}
		double x_low = -1000000, x_high = 1000000;
		while (x_high - x_low > 5e-12) {
			double x = x_low + (x_high - x_low) / 2;
			double max_v = find_max(a, x);
			double min_v = find_min(a, x);
//			System.out.printf("x=%f, min_v=%f, max_v=%f\n", x, min_v, max_v);
			if (min_v > 0 || (min_v <= 0 && max_v >= 0 && max_v >= -min_v)) {
				x_low = x;
			}
			else {
				x_high = x;
			}
		}
		out.print(find_max(a, x_low));
	}
}