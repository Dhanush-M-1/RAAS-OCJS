import java.util.Arrays;
import java.util.Scanner;


public class Codeforces360A {
	public static void main(String[] a) {
		new Codeforces360A().run();
	}
	/*
	 * 4 5
1 2 3 1
2 1 2 8
2 3 4 7
1 1 3 3
2 3 4 8

	 */
	int MAXN = 5000+5;
	int MAXM = 5000+5;
	int N, M;
	int[] plus = new int[MAXN];
	int[] val = new int[MAXN];
	int mp = 0;
	int[] ml = new int[MAXM];
	int[] mr = new int[MAXM];
	int[][] ar = new int[MAXM][MAXN];
	public void run() {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		M = in.nextInt();
		for (int _ = 0; _ < M; _++) {
			if (in.nextInt() == 1) {
				int l = in.nextInt()-1;
				int r = in.nextInt();
				int d = in.nextInt();
				for (int i = l; i < r; i++)
					plus[i] += d;
			}
			else {
				int l = in.nextInt()-1;
				int r = in.nextInt();
				int m = in.nextInt();
				ml[mp] = l;
				mr[mp] = r;
				for (int i = l; i < r; i++) {
					ar[mp][i] = m-plus[i];
				}
				mp++;
			}
		}
		for (int i = 0; i < N; i++) {
			val[i] = (int)2e9;
		}
		for (int i = 0; i < mp; i++) {
			for (int j = ml[i]; j < mr[i]; j++) {
				val[j] = Math.min(val[j], ar[i][j]);
			}
		}
		for (int i = 0; i < N; i++) {
			if (val[i] == (int)2e9)
				val[i] = 1;
		}
		boolean possible = true;
		for (int i = 0; i < mp; i++) {
			boolean good = false;
			for (int j = ml[i]; j < mr[i]; j++) {
				if (val[j] == ar[i][j]) {
					good = true;
					break;
				}
			}
			if (!good) {
				possible = false;
//				System.err.println("Error in line "+i);
//				System.err.println(Arrays.toString(val));
//				System.err.println(Arrays.toString(ar[i]));
				break;
			}
		}
		
		if (possible) {
			System.out.println("YES");
			StringBuilder sb = new StringBuilder();
			for (int i =0 ; i < N; i++)
				sb.append(val[i]).append(' ');
			sb.deleteCharAt(sb.length()-1);
			System.out.println(sb.toString());
		} else {
			System.out.println("NO");
		}
	}

}
