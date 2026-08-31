import java.util.NoSuchElementException;
import java.util.Scanner;

public class EAnalysisOfPathesInFunctionalGraph {

	static int n;
	static long k;
	static int[][] parent;
	static long[][] weights;
	static long[][] sum;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt(); k = in.nextLong();
		int K = Long.numberOfTrailingZeros(Long.highestOneBit(k)) + 1;
		parent = new int[n][K];
		for (int i = 0; i < n; i++) {
			parent[i][0] = in.nextInt();
		}
		weights = new long[n][K];
		for (int i = 0; i < n; i++) {
			weights[i][0] = in.nextLong();
		}
		sum = new long[n][K];
		for (int i = 0; i < n; i++) {
			sum[i][0] = weights[i][0];
		}
		int[] poss = new int[n];
		for (int i = 0; i < n; i++) {
			poss[i] = i;
		}
		for (int j = 1; j < K; j++) {
			for (int i = 0; i < n; i++) {
				parent[i][j] = parent[parent[i][j-1]][j-1];
				weights[i][j] = Math.min(weights[i][j-1], weights[parent[i][j-1]][j-1]);
				sum[i][j] = sum[i][j-1] + sum[parent[i][j-1]][j-1];
			}
		}
		long[] s = new long[n];
		long[] m = new long[n];
		for (int i = 0; i < n; i++) {
			m[i] = Long.MAX_VALUE;
		}
		for (int j = 0; j < K; j++) {
			if (((1L << j) & k) != 0) {
				for (int i = 0; i < n; i++) {
					s[i] += sum[poss[i]][j];
					m[i] = Math.min(m[i], weights[poss[i]][j]);
					poss[i] = parent[poss[i]][j];
				}
			}
		}
		for (int i = 0; i < n; i++) {
			System.out.println(s[i] + " " + m[i]);
		}
	}

}