
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C {
	public static void main(String[] args) throws Exception {
		int elemCnt = nextInt();
		int opCnt = nextInt();
		int[] ar = new int[elemCnt];
		int[] constraint = new int[elemCnt];
		Arrays.fill(constraint, 1000000000);
		int[][] ops = new int[opCnt][4];
		for (int i = 0; i < opCnt; i++) {
			ops[i][0] = nextInt();
			ops[i][1] = nextInt()-1;
			ops[i][2] = nextInt()-1;
			ops[i][3] = nextInt();
		}
		for (int i = opCnt - 1; i >= 0; i--) {
			if (ops[i][0] == 1) {
				for (int j = ops[i][1]; j <= ops[i][2]; j++) {
					constraint[j] -= ops[i][3];
				}
			} else {
				for (int j = ops[i][1]; j <= ops[i][2]; j++) {
					constraint[j] = Math.min(constraint[j], ops[i][3]);
				}
			}
		}
		for (int i = 0; i < constraint.length; i++) {
			ar[i] = constraint[i];
		}
//		System.out.println(Arrays.toString(ar));
		boolean valid = true;
		for (int i = 0; i <opCnt; i++) {
			if (ops[i][0] == 1) {
				for (int j = ops[i][1]; j <= ops[i][2]; j++) {
					constraint[j] += ops[i][3];
				}
			} else {
				int max = Integer.MIN_VALUE;
				for (int j = ops[i][1]; j <= ops[i][2]; j++) {
					max = Math.max(constraint[j], max);
				}
				if (max != ops[i][3]) {
//					System.out.println(max+" "+ops[i][3]+" "+i);
					valid = false;
					break;
				}
			}
//			System.out.println(Arrays.toString(constraint));
		}
		PrintWriter out = new PrintWriter(System.out);
		if (valid) {
			out.println("YES");
			for (int i = 0; i < elemCnt; i++) {
				out.print(Math.min(ar[i],1000000000) + " ");
			}
			out.println();
		} else {
			out.println("NO");
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
