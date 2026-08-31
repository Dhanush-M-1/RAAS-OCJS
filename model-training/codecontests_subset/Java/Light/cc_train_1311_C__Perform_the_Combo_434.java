import java.util.*;

public class Dij
{
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int t=in.nextInt();
		while(t>0)
		{
			t--;
			int n=in.nextInt();
			int m=in.nextInt();
			char[] c=new char[n];
			c=in.next().toCharArray();
			int mistake[]=new int[n];
			for(int i=0;i<m;i++)
			{
				int pos=in.nextInt()-1;
				mistake[pos]++;
			}
			int dp[]=new int[n];
			dp[n-1]=1;
			int cdp[]=new int[26];
			for(int i=n-2;i>=0;i--)
			{
				dp[i]=mistake[i]+dp[i+1];
			}
			for(int i=0;i<c.length;i++)
			{
				cdp[c[i]-'a']+=dp[i];
			}
			for(int i=0;i<26;i++)
				System.out.print(cdp[i]+" ");
			System.out.println();
	}
}
}