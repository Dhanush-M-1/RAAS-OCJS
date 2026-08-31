import java.io.*;
import java.util.*;
public class TestClass {
    static PrintWriter out = new PrintWriter(System.out);
    public static void main(String args[] ) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(in.readLine());
    	String s = in.readLine();
    	int dp[][] = new int[26][n+1];
    	for(int c=0;c<26;c++)
    	{
    		for(int i=0;i<n;i++)
    		{
        		int m=0;
    			for(int j=i;j<n;j++)
    			{
    				if((s.charAt(j)-'a')!=c)
    				{
    					m++;
    				}
    				dp[c][m] = Math.max(dp[c][m], j-i+1);
    			}
    		}
    	}
    	for(int c =0;c<26;c++)
    	{
    		for(int j=1;j<n+1;j++)
    		{
    			dp[c][j] = Math.max(dp[c][j], dp[c][j-1]);
    		}
    	}
    	int q = Integer.parseInt(in.readLine());
    	for(int z=0;z<q;z++)
    	{
    		String s1[] = in.readLine().split(" ");
    		int v = Integer.parseInt(s1[0]);
    		int u = s1[1].charAt(0)-'a';
    		out.println(dp[u][v]);
    	}
    	out.close();
    }
} 