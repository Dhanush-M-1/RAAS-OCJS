import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String [] Args)
	{
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int m=in.nextInt();
		long [] vis=new long [n+1];
		vis[0]=1;
		for(int i=0;i<m;i++)
		{
			int k=in.nextInt();
			vis[k]=-1;
		}
		if(vis[1]!=-1)
			vis[1]=1;
		for(int i=2;i<=n;i++)
		{
			if(vis[i]!=-1)
			{
				if(vis[i-1]==-1)
					vis[i]=vis[i-2];
				else if(vis[i-2]==-1)
					vis[i]=vis[i-1];
				else
				    vis[i]=(vis[i-1]+vis[i-2])%1000000007;
			}
		}
		if(vis[n]==-1)
			vis[n]=0;
		System.out.println(vis[n]);
	}
}
	