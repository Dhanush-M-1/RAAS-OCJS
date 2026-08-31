import java.util.Scanner;

public class Main{//ABC129C

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.next());
		int M = Integer.parseInt(sc.next());
		
		boolean[] list = new boolean[N+1];
		
		for(int i=0;i<M;i++){
			int a = Integer.parseInt(sc.next());
			list[a] = true;
		}
		
		long[] dp = new long[N+1];
		dp[0]=1;
		for(int now=0;now<N;now++) {
			for(int next=now+1;next<=Math.min(N,now+2);next++) {
				if(!(list[next])) {
					dp[next]+=dp[now];
					dp[next]%=1000000007;
				}
			}
		}
		System.out.println(dp[N]);
	}
}