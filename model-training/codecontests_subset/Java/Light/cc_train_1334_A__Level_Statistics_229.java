

import java.util.Scanner;

public class TP {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int i=0;i<t;i++)
		{
			int n=sc.nextInt();
			int p[]=new int[n];
			int c[]=new int[n];
			int pmax=-1,cmax=-1;
			for(int j=0;j<n;j++)
			{
				p[j]=sc.nextInt();
				c[j]=sc.nextInt();
			}
			boolean flag=false;
			for(int j=0;j<n;j++)
			{
				if(p[j]>=pmax)
				{
					pmax=p[j];
				}
				else
				{
					flag=true;
					//System.out.println("1");
					break;
				}
				if(c[j]>=cmax)
				{
					cmax=c[j];
				}
				else
				{
					flag=true;
					//System.out.println("2");
					break;
				}
				if(c[j]>p[j])
				{
					//System.out.println(p[j]+" 3 "+c[j]);
					flag=true;
					break;
				}
				if(j!=0 && c[j]-c[j-1]>p[j]-p[j-1])
				{
					flag=true;
					break;
				}
			}
			if(flag==false)
			{
				System.out.println("YES");
			}
			else
			{
				System.out.println("NO");
			}
		}
	}
}
