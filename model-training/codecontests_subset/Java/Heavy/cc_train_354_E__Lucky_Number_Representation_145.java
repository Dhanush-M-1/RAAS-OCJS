

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class E {
	static boolean vis[][][][];
	static int[] vals;
	static boolean found;
	static int[][] construct;
	static int[] nexts = new int[] { 7, 4, 0 };

	public static void dfs(int decPlace, int row, int sum, int carry) {
		if (found)
			return;
		// System.out.println("das");
		if (decPlace < 0) {
			if (carry == 0&&sum==0) {
				// for (int j = 0; j < construct.length; j++)
				// System.out.println("a7eh"+Arrays.toString(construct[j]));
				found = true;
			}
			return;
		}
		vis[decPlace][row][sum][carry] = true;
		int curSum = carry * 10 + sum;
		for (int i = 0; i < 3 && !found; i++) {
			int pos = curSum + nexts[i];
			if (row == 5 && pos % 10 != vals[decPlace])
				continue;
			int newDec = decPlace, newRow = row + 1;
			int newSum = pos % 10;
			int newCarry = pos / 10;
			if (row == 5) {
//				System.out.println(decPlace + " " + row + " " + sum + " "
//						+ carry + "  fa " + pos + " " + curSum);
//				for (int j = 0; j < construct.length; j++)
//					System.out.println(Arrays.toString(construct[j]));
				newDec--;
				newRow = 0;
				newSum = newCarry;
				newCarry = 0;
			}
			if (newDec < 0 || !vis[newDec][newRow][newSum][newCarry]) {
				construct[row][decPlace] = nexts[i];
				dfs(newDec, newRow, newSum, newCarry);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		int numCnt = nextInt();
		PrintWriter out = new PrintWriter(System.out);
		for (int i = 0; i < numCnt; i++) {
			String t = next();
			vals = new int[t.length()];
			long num = Long.parseLong(t);
			for (int j = t.length() - 1; j >= 0; --j) {
				vals[j] = (int) (num % 10);
				num /= 10;
			}
//			System.out.println(Arrays.toString(vals));
			vis = new boolean[t.length()][6][10][10];
			construct = new int[6][t.length()];
			found = false;
			dfs(vals.length - 1, 0, 0, 0);
//			for (int j = 0; j < construct.length; j++)
//				System.out.println("a7a" + Arrays.toString(construct[j]));
			if (found) {
				for (int j = 0; j < construct.length; j++) {
					long tmp = 0;
					for (int k = 0; k < construct[j].length; k++) {
						tmp *= 10;
						tmp += construct[j][k];
					}
					out.print(tmp + " ");
				}
				out.println();
			} else {
				out.println("-1");
			}
		}
		out.flush();
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(
			System.in));
	static StringTokenizer tokenizer = new StringTokenizer("");

	static int nextInt() throws Exception {
		return Integer.parseInt(next());
	}

	static double nextDouble() throws Exception {
		return Double.parseDouble(next());
	}

	static String next() throws Exception {
		while (true) {
			if (tokenizer.hasMoreTokens()) {
				return tokenizer.nextToken();
			}
			String s = br.readLine();
			if (s == null) {
				return null;
			}
			tokenizer = new StringTokenizer(s);
		}
	}
}
