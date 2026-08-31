import java.util.*;
public class class111 {
public static void main(String arg[])
{
	Scanner sc=new Scanner(System.in);
	int t=sc.nextInt();
	while(t-->0)
	{
		int k,n,m,i,j;
		k=sc.nextInt();
		n=sc.nextInt();
		m=sc.nextInt();
		int a[]=new int[n];
		int b[]=new int[m];
		for(i=0;i<n;i++)
		{
			a[i]=sc.nextInt();
		}
		for(i=0;i<m;i++)
		{
			b[i]=sc.nextInt();
		}
		int pos1=0,pos2=0;
		int c[]=new int[n+m];
		int d=0;
		int flag=0;
		while(pos1!=n || pos2!=m)
		{
			if(pos1!=n && a[pos1]==0)
			{
				c[d]=0;
				pos1++;
				k++;
				d++;
			}
			else if(pos2!=m && b[pos2]==0)
			{
				c[d]=0;
				pos2++;
				k++;
				d++;
			}
			else if(pos1!=n && a[pos1]<=k)
			{
				c[d]=a[pos1];
				d++;
				pos1++;
			}
			else if(pos2!=m && b[pos2]<=k)
			{
				c[d]=b[pos2];
				d++;
				pos2++;
			}
			else
			{
				System.out.println(-1);
				flag=1;
				break;
			}
		}
		if(flag==0)
		{
			for(i=0;i<n+m;i++)
			{
				System.out.print(c[i]+" ");
			}
			System.out.println();
		}
	}
}
}
