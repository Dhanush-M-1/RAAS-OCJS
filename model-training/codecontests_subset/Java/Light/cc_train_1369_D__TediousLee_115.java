import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;

	public static int N, K;
	public static long[] pows = new long[2000007];
	public static final long MOD = (long) (1e9 + 7);

	public static void main(String[] args) throws IOException {
		int iter = Integer.parseInt(br.readLine());

		pows[0] = 0;
		pows[1] = 0;
		for (int i = 2; i < pows.length; i++) {
			pows[i] = pows[i - 1] + pows[i - 2] * 2;
			if (i % 3 == 0) {
				pows[i]++;
			}
			pows[i] %= MOD;
		}

		while (iter-- > 0) {
			solve();
		}
		bw.flush();
	}

	private static void solve() throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());

		bw.write((pows[N] * 4 % MOD) + "\n");
	}

}
