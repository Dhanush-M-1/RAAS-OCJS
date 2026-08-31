import static java.lang.Math.*;

import java.util.*;

public class E {

	public static void main (String [] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long [][] A = new long [N][N];
		read(sc, 0, N, A);
		fw(0, N, A);

		long res = maximum(0, 0, N, A);
		System.out.println(res);
	}

	private static void read(Scanner sc, int Z, int N, long [][] A) {
		int i = Z/N, j = Z%N;
		try {
			A[i][j] = sc.nextInt();
			read(sc, Z+1, N, A);
		} catch (Exception e) {
		}
	}

	private static long maximum(long X, int Z, int N, long [][] A) {
		int i = Z/N, j = Z%N;
		try {
			X = max(X, A[i][j]);
			return maximum(X, Z+1, N, A);
		} catch (Exception e) {
			return X;
		}
	}

	private static long [][] fw(int Z, int N, long [][] G) {
		int k = Z/(N*N), i = (Z%(N*N))/N, j = Z%N;
		G[i][j] = min(G[i][j], G[i][k] + G[k][j]);
		try {
			return fw(Z+1, N, G);
		} catch (Exception e) {
			return G;
		}
	}
}
