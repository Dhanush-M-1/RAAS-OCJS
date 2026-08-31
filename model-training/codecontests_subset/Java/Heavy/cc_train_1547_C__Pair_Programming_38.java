import java.util.*;
public class pairprogramming
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int t=in.nextInt();
		for(int ii=0;ii<t;ii++)
		{
			int k,n,m;
			k=in.nextInt();
			n=in.nextInt();
			m=in.nextInt();
			int arrn[]=new int[n];
			int arrm[]=new int[m];
			for(int i=0;i<n;i++)
				arrn[i]=in.nextInt();
			for(int i=0;i<m;i++)
				arrm[i]=in.nextInt();
			
			boolean flag=true;
			int seqnm[]=new int[n+m];
			int i=0;
			int j=0;
			int p=0;
			while(i<n&&j<m)
			{
				if(k>=arrn[i]&&arrn[i]!=0)
				{
					seqnm[p++]=arrn[i++];
				}
				else if(k>=arrm[j]&&arrm[j]!=0)
				{
					seqnm[p++]=arrm[j++];
				}
				else if(arrn[i]==0)
				{
					seqnm[p++]=0;
					k++;
					i++;
				}
				else if(arrm[j]==0)
				{
					seqnm[p++]=0;
					k++;
					j++;
				}
				else
				{
					flag=false;
					break;
				}
			}
			while(i<n)
			{
				if(k>=arrn[i]&&arrn[i]!=0)
				{
					seqnm[p++]=arrn[i++];
				}
				else if(arrn[i]==0)
				{
					seqnm[p++]=0;
					k++;
					i++;
				}
				else
				{
					flag=false;
					break;
				}
			}
			while(j<m)
			{
				if(k>=arrm[j]&&arrm[j]!=0)
				{
					seqnm[p++]=arrm[j++];
				}
				else if(arrm[j]==0)
				{
					seqnm[p++]=0;
					k++;
					j++;
				}
				else
				{
					flag=false;
					break;
				}
			}
			if(flag)
			{
				for(int r=0;r<n+m;r++)
					System.out.print(seqnm[r]+" ");
					System.out.println();
			}
			else
			{
				System.out.println(-1);
			}
		}
	}
}