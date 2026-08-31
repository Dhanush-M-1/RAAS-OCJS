import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Juwon {
	static final int SIZE = 2000000;
	static final long MOD = 1000000007l;
	static int N;
	static long dp[] = new long[SIZE + 1];
	static long result[] = new long[SIZE + 1];

	public static void main(String[] args0) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		dp[1] = 1;
		dp[2] = 1;
		for (int i = 3; i <= SIZE; i++) {
			dp[i] = ((dp[i - 1] + dp[i - 2] * 2) % MOD);
			if (i > 5) {
				result[i] = dp[i - 2] + result[i - 3];
				result[i] %= MOD;
			} else {
				result[i] = dp[i - 2];
			}
		}
		
		int T = Integer.parseInt(br.readLine().trim());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine().trim());
			bw.write(((result[N] * 4) % MOD) + "\n");
		}
		bw.close();
	}
}