import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
	public static BufferedReader in;
	public static PrintWriter out;

	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);

		boolean showLineError = true;
		if (showLineError) {
			solve();
			out.close();
		} else {
			try {
				solve();
			} catch (Exception e) {
			} finally {
				out.close();
			}
		}

	}

	private static final long MAX = 1000000000;

	private static void solve() throws IOException {
		String[] line = nss();
		int n = Integer.parseInt(line[0]);
		int m = Integer.parseInt(line[1]);
		long[][] operation = new long[m][];
		for (int i = 0; i < m; i++) {
			line = in.readLine().split(" ");
			long[] add = new long[4];
			for (int j = 0; j < 4; j++)
				add[j] = Long.valueOf(line[j]);
			add[1]--;
			add[2]--;
			operation[i] = add;

		}
		long[] arr = new long[n];
		for (int i = 0; i < n; i++) {
			long value = MAX;
			long acum = 0;
			for (int j = 0; j < m; j++) {
				if (adentro(i, operation[j]))
					if (operation[j][0] == 1) {
						acum += operation[j][3];
					} else {
						value = Math.min(value, operation[j][3] - acum);
					}
			}
			arr[i] = value;
		}

		for (long a : arr)
			if (Math.abs(a) > MAX) {
				out.println("NO");
				return;
			}
		long[] check = arr.clone();
		if (!pass(operation, check)) {
			out.println("NO");
			return;
		}
		out.println("YES");
		for (int i = 0; i < arr.length; i++)
			if (i == 0) {
				out.print(arr[i]);
			} else {
				out.print(" " + arr[i]);
			}
		out.println();

	}

	private static boolean pass(long[][] operation, long[] check) {
		int n = check.length;
		int m = operation.length;
		for (int i = 0; i < m; i++)
			if (operation[i][0] == 1) {
				for (long j = operation[i][1]; j <= operation[i][2]; j++)
					check[(int) j] += operation[i][3];
			} else {
				long max = -MAX;
				for (long j = operation[i][1]; j <= operation[i][2]; j++)
					max = Math.max(max, check[(int) j]);
				if (max != operation[i][3])
					return false;

			}
		return true;
	}

	private static boolean adentro(int i, long[] ls) {
		return (ls[1] <= i) && (i <= ls[2]);
	}

	private static int ni() throws NumberFormatException, IOException {
		return Integer.parseInt(in.readLine());
	}

	private static String[] nss() throws IOException {
		return in.readLine().split(" ");
	}

	static void debug(Object... os) {
		out.println(Arrays.deepToString(os));
	}

}