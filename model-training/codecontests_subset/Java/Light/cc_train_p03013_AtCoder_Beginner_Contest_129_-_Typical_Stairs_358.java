import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	private static final int MOD = 1000000007;

	public static void main(String[] args) {

		try(BufferedReader bf =
				new BufferedReader(new InputStreamReader(System.in))) {
			String[] s = bf.readLine().split(" ");
			int N = Integer.parseInt(s[0]);
			int M = Integer.parseInt(s[1]);
			boolean[] flag = new boolean[N+1];
			Arrays.fill(flag, true);
			ArrayList<Integer> a = new ArrayList<>();
			for(int i = 0;i < M;i++) {
				a.add(Integer.parseInt(bf.readLine()));
				flag[a.get(i)] = false;
			}

			int[] dp = new int[N+1];
			dp[0] = 1;
			for(int now = 0;now < N;now++) {
				for(int next = now+1;next <= Math.min(N, now+2);next++) {
					if(flag[next]) {
						dp[next] += dp[now];
						dp[next]%=MOD;
					}
				}
			}
			System.out.println(dp[N]);

		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}