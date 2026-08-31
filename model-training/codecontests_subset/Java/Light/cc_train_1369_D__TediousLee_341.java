
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int mod=1000000007;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stu
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		long[] dp=new long[2000001];
		dp[1]=0;
		dp[2]=0;
		dp[3]=1;
		for(int i=4;i<=2000000;i++)
		{
			dp[i]=dp[i-1]+2*dp[i-2];
			if(i%3==0)
				dp[i]++;
			dp[i]=dp[i]%mod;
		}
		int cases=Integer.valueOf(br.readLine());
		while(cases!=0)
		{
			cases--;
			int n=Integer.valueOf(br.readLine());
			System.out.println((dp[n]*4)%mod);
		}
		}}
