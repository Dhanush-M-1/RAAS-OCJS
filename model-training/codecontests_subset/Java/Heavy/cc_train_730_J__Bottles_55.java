import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class chocolate {
	static int n;
	static Pair[][] memo;
	static int[] amount,vol,sum;
	static Pair dp(int ind,int total)
	{
		if(total<0)return new Pair((int)1e9,(int)1e9);
		if(ind>=n)return (total==0)? new Pair(0, 0):new Pair((int)1e9,(int)1e9);
		if(total>sum[ind])return new Pair((int)1e9,(int)1e9);
		if(memo[ind][total]!=null)return memo[ind][total];
		Pair ans = dp(ind+1,total).clone();
		for(int i = 1; i<=vol[ind];i++)
		{
			Pair cur = dp(ind+1,total-i).clone();
			cur.bottles++;
			cur.time+=Math.max(0, i-amount[ind]);
			if(cur.bottles<ans.bottles)ans = cur;
			else if(cur.bottles == ans.bottles && cur.time<ans.time)ans = cur;
		}
		return memo[ind][total] = ans;
	}
    public static void main(String[]args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        amount = new int[n];
        vol = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int total = 0;
        for (int i = 0; i < amount.length; i++) 
			total += amount[i] = Integer.parseInt(st.nextToken());
		
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < amount.length; i++) 
			vol[i] = Integer.parseInt(st.nextToken());
        sum = new int[n];
        sum[n-1] = vol[n-1];
        for(int i = n-2;i>=0;i--)
        	sum[i] = sum[i+1] + vol[i];
		memo = new Pair[n][1+(int)1e4];
		Pair ans = dp(0,total);
		System.out.println(ans.bottles+" "+ans.time);
    }
    static class Pair
    {
    	int bottles,time;
    	public Pair(int b,int t) {
			bottles = b;
			time = t;
		}	
    	
    	public Pair clone()
    	{
    		return new Pair(bottles, time);
    	}
    }
}
