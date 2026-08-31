
import java.util.Scanner;

public class lul {

	public static void main(String args[])
	{
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int m=scan.nextInt();
		int last[]=new int[n+1];
		int count[]=new int[n+1];
		for(int i=1;i<=n;i++)
		{
			last[i]=n;
		}
		int a,b;
		for(int i=1;i<=m;i++)
		{
			a=scan.nextInt();b=scan.nextInt();
			count[a]++;
			if(b>a)
			{
				last[a]=Math.min(last[a], b-a);
				
			}else{
				last[a]=Math.min(last[a],(n+b-a));
			}
			
		}
		for(int i=1;i<=n;i++)
		{
			int ans=0;
			for(int j=1;j<=n;j++)
			{
				if(count[j]>0)
				{
				if(j>=i)
				{
				ans=Math.max(ans, (j-i)+(count[j]-1)*n+last[j]);
				}else{
					ans=Math.max(ans,(n+j-i)+(count[j]-1)*n+last[j]);
				}
				}
			}
			System.out.print(ans+" ");
		}
		
	}
}
