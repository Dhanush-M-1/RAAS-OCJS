//https://codeforces.com/contest/1513/problem/C
//C. Add One
import java.util.*;
import java.io.*;
public class CF_1513_C{
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int mod = (int)1e9+7;

		int max_m = 200000+5;

		int dp[] = new int[max_m];
		for(int i=0;i<9;i++)
			dp[i] = 2;
		dp[9] = 3;

		for(int i=10;i<max_m;i++){
			dp[i] = (dp[i-10]+dp[i-9])%mod;
		}

		int t = Integer.parseInt(br.readLine());

		while(t-->0){
			st = new StringTokenizer(br.readLine().trim());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			int ans = 0;

			while(n>0){
				int x = n%10;
				if(m+x<10)
					ans += 1;
				else
					ans += dp[x+m-10];
				ans%=mod;
				n/=10;
			}

			sb.append(ans).append("\n");
		}

		pw.print(sb);
		pw.flush();
		pw.close();
	}
}