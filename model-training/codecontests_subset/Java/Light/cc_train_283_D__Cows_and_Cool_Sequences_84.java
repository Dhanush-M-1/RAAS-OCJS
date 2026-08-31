import java.util.Arrays;
import java.util.Scanner;


public class problem283D {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		long[] z=new long[5005];
		for(int q=1;q<=n;q++)
			z[q]=scan.nextLong();
		long[] x=new long[5005];
		int[] c=new int[5005];
		for(int q=1;q<=n;q++)
		{
			x[q]=z[q];
			for(;(x[q]&1)==0;)
			{
				x[q]>>=1;
				c[q]++;
			}
		}
		int[] dp=new int[5005];
//		Arrays.fill(dp,10000);
		dp[1]=0;
		for(int q=2;q<=n;q++)
		{
			dp[q]=q-1;
			for(int w=1;w<q;w++)
			{
				if(x[w]%x[q]==0&&(c[q]<=q-w-1||c[q]-c[w]==q-w))
					dp[q]=Math.min(dp[q],dp[w]+q-w-1);
			}
//			System.out.println(dp[q-1]);
		}
//		System.out.println(dp[n]);
		int ans=100000;
		for(int q=1;q<=n;q++)
			ans=Math.min(dp[q]+n-q,ans);
		System.out.println(ans);
	}

}
