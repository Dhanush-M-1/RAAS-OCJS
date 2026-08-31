import java.util.*;
import java.io.*;

public class problem714_c {

	static StreamTokenizer in;

	static int nextInt() throws Exception {
		in.nextToken();
		return (int) in.nval;
	}

	static String next() throws Exception {
		in.nextToken();
		return (String) in.sval;
	}
	static long[][]dp=new long[10][200_000+1];
	static int mod=1_000_000_000+7;
	public static void main(String[] args) throws Exception {
		//in = new StreamTokenizer(new BufferedReader(new FileReader("test.in")));
		    in=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		for(int i=0;i<10;i++) fill(i);
		int t=nextInt();
		StringBuilder ans=new StringBuilder();
		for(int i=0;i<t;i++) ans.append(solve()).append("\n");
		System.out.println(ans);
	}
	static String solve() throws Exception{
		int n=nextInt(), m=nextInt();
		long ans=0;
		while(n>0) {
			ans=(ans+dp[n%10][m])%mod;
			n/=10;
		}
		return ""+ans;
	}
	static void fill(int num) {
		int m=200_000;
		long []curr=new long[10];
		curr[num]++;
		dp[num][0]=1;
		for(int i=1;i<=m;i++) {
			long []temp=new long[10];
			for(int j=1;j<=9;j++) {
				temp[j]=curr[j-1];
			}
			temp[0]=(temp[0]+curr[9])%mod; temp[1]=(temp[1]+curr[9])%mod;
			curr=temp;
			for(long val:curr) dp[num][i]=(dp[num][i]+val)%mod;
		}
	}
}

