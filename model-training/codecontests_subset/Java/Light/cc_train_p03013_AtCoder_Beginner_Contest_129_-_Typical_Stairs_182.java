import java.util.*;

public class Main {
	public static void main(String[] args) {
		Main main = new Main();
		main.run();
	}

	public void run() {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		int M=sc.nextInt();
		ArrayList<Integer> a = new ArrayList<Integer>();
		for(int i=0; i<M; i++) {
			a.add(sc.nextInt());
		}

		int MOD = 1000000007;
		long dp[] = new long[N+1];
		dp[0] = 1;
		int j=0;
		for(int i=1; i<=N; i++) {
			if(j<M && a.get(j) == i) {
				j++;
				continue;
			}
			dp[i] += dp[i-1];
			dp[i] %= MOD;
			if(i-2>=0) {
				dp[i] += dp[i-2];
				dp[i] %= MOD;
			}
		}
		System.out.println(dp[N]);
		sc.close();
	}
}
