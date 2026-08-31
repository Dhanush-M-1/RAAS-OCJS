import java.io.PrintStream;
import java.util.Scanner;

public class Main {
	//static final PrintStream out = System.out; 多分大丈夫
	static Scanner sc = new Scanner(System.in);
	static final long Mod = 1000_000_007L;
	public static void main(String[] args) {
		Main main = new Main();
		main.solve();
		System.exit(0);
	}

	void solve() {
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] a = new int[M+2];
		for(int i=1;i<=M;i++) {   //0段目を配列a[0]に入れている
			a[i]=sc.nextInt();
		}
		sc.close();
		long[] dp = new long[N+1];
		int ta = 1;
		dp[0] = 1;
		if(a[ta]!=1)dp[1]=dp[0];
		else ta++;
		for(int i=2;i<=N;i++) {
			if(a[ta]!=i) {
				dp[i] = dp[i-2]+dp[i-1];
				dp[i]-=dp[i]>Mod?Mod:0;
			}else {
				ta++;
			}
		}
		//out.println(dp[N]);
		System.out.println(dp[N]);
	}
	/*private static int nextInt() {		プログラムを高速化するためのメソッドで無くても大丈夫
		return Integer.parseInt(next());
	}
	private static long nextLong() {
		return Long.parseLong(next());
	}
	private static String next() {
		return sc.next();
	}
	*/

}
