
import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int suma=0;
		int sumb=0;
		int kk=0;
		Vx[] c=new Vx[n+1];
		c[0]=new Vx(9999,9999);
		for(int i=1;i<=n;i++)
		{
			int t=sc.nextInt();
			c[i]=new Vx(t,0);
			suma+=t;
		}
		
		for(int i=1;i<=n;i++)
		{
			
			c[i].b=sc.nextInt();
		}
		Arrays.sort(c);
		while(sumb<suma)
		{
			sumb+=c[++kk].b;
		}
		int[][] dp=new int[10005][105];
		for(int i=0;i<10005;i++)Arrays.fill(dp[i],-9999);
		dp[0][0]=0;
		for(int i=1;i<=n;i++)
		{
			for(int j=sumb;j>=c[i].b;j--)
			{
				for(int k=1;k<=kk;k++)
				{
					dp[j][k]=Math.max(dp[j][k],dp[j-c[i].b][k-1]+c[i].a);
				}
			}
		}
		int ans=0;
		for(int i=suma;i<=sumb;i++)ans=Math.max(ans, dp[i][kk]);
		System.out.print(kk+" "+(suma-ans));
	}

}
class Vx implements Comparable<Vx>
{
	int a;
	int b;
	Vx(){}
	Vx(int a,int b){
		this.a=a;
		this.b=b;
	}
	@Override
	public int compareTo(Vx o) {
		// TODO 自动生成的方法存根
		return o.b-this.b;
	}
	
	
	
}