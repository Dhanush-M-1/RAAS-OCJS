import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
public class newr
{
	public static void main (String[] args)
	 {
		Scanner sc=new Scanner(System.in); 
		int t,i;
		t=1;
		while(t>0)
		{
			t--;
			int n=sc.nextInt();
			int k=sc.nextInt();
			int d[][]=new int[n][3];
			int al=0,bl=0;
			for(i=0;i<n;i++)
			{
				d[i][0]=sc.nextInt();
				d[i][1]=sc.nextInt();
				d[i][2]=sc.nextInt();
				if(d[i][1]==1)
					al++;
				if(d[i][2]==1)
					bl++;
			}
			if(al<k||bl<k)
			{
				System.out.println(-1);
				return;
			}
			ArrayList<Integer> b=new ArrayList();
			ArrayList<Integer> a=new ArrayList();
			ArrayList<Integer> bo=new ArrayList();
			for(i=0;i<n;i++)
			{
				if(d[i][1]==1&&d[i][2]==1)
					b.add(d[i][0]);
				else if(d[i][1]==0&&d[i][2]==1)
					bo.add(d[i][0]);
				else if(d[i][1]==1&&d[i][2]==0)
					a.add(d[i][0]);
			}
			Collections.sort(b);
			Collections.sort(bo);
			Collections.sort(a);
			long ans=0;
			int j,l,m;
			j=0;l=0;m=0;
			for(i=0;i<n;i++)
			{
				if(l<b.size()&&j<bo.size()&&m<a.size())
				{
					int s=b.get(l);
					int dono=bo.get(j)+a.get(m);
					if(s<=dono)
					{
						ans+=s;
						l++;
					}
					else
					{
						ans+=dono;
						j++;
						m++;
					}
					k--;
					if(k==0)
						break;
				}
				else break;
			}
			if(k>0)
			{
				if(l==b.size())
				{
					while(k>0)
					{
						int dono=bo.get(j)+a.get(m);
						ans+=dono;
						j++;
						m++;
						k--;
					}
				}
				else
				{
					while(k>0)
					{
						int s=b.get(l);
						ans+=s;
						l++;
						k--;
					}
				}
			}
			System.out.println(ans);
		}
	}
}